package com.rx;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;
import rx.Observable;
import rx.Observer;
import rx.Scheduler;
import rx.schedulers.Schedulers;

import java.util.ArrayList;
import java.util.List;

@RunWith(MockitoJUnitRunner.class)
public class TestRxMethod {

    // prod Bar class - this class tested in isolation in different test.
    public static class Bar {

        public Observable<Integer> foo() {
            return null;
        }
    }

    // prod FooSubscriber class - this class tested in isolation in different test.
    public static class FooSubscriber implements Observer<Integer> {

        @Override
        public void onCompleted() {
        }

        @Override
        public void onError(Throwable e) {
        }

        @Override
        public void onNext(Integer t) {
        }
    }

    // prod FooSubscriberFactory class - this class tested in isolation in different test.
    public static class FooSubscriberFactory {

        public Observer<Integer> getInstance() {
            return null;
        }
    }

    // prod "class under test"
    public static class UnderTest {
        private final Bar bar;
        private final Scheduler computationScheduler;
        private final Scheduler ioScheduler;
        private final FooSubscriberFactory fooSubscriberFactory;

        public UnderTest(Bar bar, Scheduler computationScheduler, Scheduler ioScheduler,
                FooSubscriberFactory fooSubscriberFactory) {
            this.bar = bar;
            this.computationScheduler = computationScheduler;
            this.ioScheduler = ioScheduler;
            this.fooSubscriberFactory = fooSubscriberFactory;
        }

        public void start() {
            //@formatter:off
            bar.foo()
                .filter(i -> i.intValue() % 2 == 0)
                .subscribeOn(computationScheduler)
                .observeOn(ioScheduler)
                .subscribe(fooSubscriber());
            //@formatter:on
        }

        // package private so can be overridden by unit test some drawbacks
        // using this strategy like class cant be made final. - use only
        // if cant restructure code.
        Observer<Integer> fooSubscriber() {
            return fooSubscriberFactory.getInstance();
        }
    }

    // test Foo subscriber class - test will put set an instance of
    // this class as the observer on the callback chain.
    public static class TestFooSubscriber implements Observer<Integer> {

        public List<Integer> filteredIntegers = new ArrayList<>();

        @Override
        public void onCompleted() {
            // noop
        }

        @Override
        public void onError(Throwable e) {
            // noop
        }

        @Override
        public void onNext(Integer i) {
            // aggregate filtered integers for later assertions
            filteredIntegers.add(i);
        }
    }

    // mock bar for test
    private Bar bar;

    // mock foo subscriber factory for test
    private FooSubscriberFactory fooSubscriberFactory;

    // class under test - injected with test dependencies
    private UnderTest underTest;

    @Before
    public void setup() {
        bar = Mockito.mock(Bar.class);
        fooSubscriberFactory = Mockito.mock(FooSubscriberFactory.class);
        underTest = new UnderTest(bar, Schedulers.immediate(), Schedulers.immediate(), fooSubscriberFactory);
    }

    // Option #1 - injecting a factory
    @Test
    public void start_shouldWork_usingMockedFactory() {
        // setup bar mock to emit integers
        Mockito.when(bar.foo()).thenReturn(Observable.just(1, 2, 3, 4, 5, 6, 7, 8, 9, 10));

        // setup the subscriber factory to produce an instance of the test subscriber
        TestFooSubscriber testSubscriber = new TestFooSubscriber();
        Mockito.when(fooSubscriberFactory.getInstance()).thenReturn(testSubscriber);

        underTest.start();

        Assert.assertEquals(5, testSubscriber.filteredIntegers.size());
        // ... add more assertions as needed per the use cases ...
    }

    // Option #2 - spying a protected method
    @Test
    public void start_shouldWork_usingSpyMethod() {
        // setup bar mock to emit integers
        Mockito.when(bar.foo()).thenReturn(Observable.just(1, 2, 3, 4, 5, 6, 7, 8, 9, 10));

        // spy the class under test (use only as a last resort option)
        underTest = Mockito.spy(underTest);
        TestFooSubscriber testSubscriber = new TestFooSubscriber();
        Mockito.when(underTest.fooSubscriber()).thenReturn(testSubscriber);

        underTest.start();

        Assert.assertEquals(5, testSubscriber.filteredIntegers.size());
        // ... add more assertions as needed per the use cases ...
    }
}