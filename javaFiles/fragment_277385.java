import static org.junit.Assert.assertEquals;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import rx.Observable;
import rx.Subscription;
import rx.observers.TestSubscriber;
import rx.subjects.PublishSubject;
import rx.subscriptions.BooleanSubscription;

public class Q47049714 {

  public static class BluetoothFailure extends Exception {
  }

  public static class CheckInSuccess implements CheckInResult {
  }

  public static interface CheckInResult {
  }

  public class ShopRepository {
    public Observable<CheckInResult> checkIn() {
      return checkinSubject;
    }
  }

  public class UserRepository {
    public Observable<Void> checkIn() {
      return Observable.just(null);
    }
  }

  public class DeviceCheckInUseCase {
    ShopRepository shopRepository = new ShopRepository();
    UserRepository userRepository = new UserRepository();

    public Observable<CheckInResult> checkIn() {
      return Observable.create(subscriber -> {
        Subscription subscription = new BooleanSubscription();
        shopRepository
            .checkIn()
            .retryWhen(failure -> failure.flatMap(result -> {
              if (result instanceof BluetoothFailure) {
                return Observable.error(result);
              } else if (!subscription.isUnsubscribed()) {
                return Observable.just(0);
              } else {
                return Observable.error(result);
              }
            }))
            .flatMap(checkInResult -> userRepository.checkIn().map(v -> checkInResult))
            .subscribe(subscriber);
      });
    }
  }

  PublishSubject<CheckInResult> checkinSubject;
  DeviceCheckInUseCase deviceCheckInUseCase;
  TestSubscriber<CheckInResult> subscriber;

  @Before
  public void setUp() {
    checkinSubject = PublishSubject.create();
    subscriber = new TestSubscriber<>();
    deviceCheckInUseCase = new DeviceCheckInUseCase();
  }

  @Test
  public void testCheckInSucceeded() {
    final ArrayList<CheckInResult> succeeded = new ArrayList<>();
    final ArrayList<Throwable> failed = new ArrayList<>();

    deviceCheckInUseCase.checkIn()
        .doOnNext(succeeded::add)
        .doOnError(failed::add)
        .subscribe(subscriber);

    subscriber.assertValueCount(0);
    assertEquals(0, succeeded.size());
    assertEquals(0, failed.size());

    checkinSubject.onNext(new CheckInSuccess());

    subscriber.assertValueCount(1);
    assertEquals(1, succeeded.size());
    assertEquals(0, failed.size());
  }
}