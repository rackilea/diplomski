import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

@RunWith(SpringRunner.class)
@Transactional
@SpringBootTest
public class UserRepoTests {

    @Autowired
    private UserRepo userRepo;

    @Test
    public void testSelectForUpdate() throws InterruptedException {

        final Runnable requestOne = () -> {
            try {
                userRepo.lockUser(1L, true); // this one should wait and block the others
            } catch (InterruptedException e) {
            }
        };

        final Runnable requestTwo = () -> {
            try {
                userRepo.lockUser(1L, false);
            } catch (InterruptedException e) {
            }
        };

        final Runnable requestThree = () -> {
            try {
                userRepo.lockUser(1L, false);
            } catch (InterruptedException e) {
            }
        };

        final Thread threadOne = new Thread(requestOne);
        threadOne.start();

        Thread.sleep(1000); // give the first one some time to start

        final Thread threadTwo = new Thread(requestTwo);
        threadTwo.start();
        final Thread threadThree = new Thread(requestThree);
        threadThree.start();

        Thread.sleep(20000); // wait before destroying context
    }

}