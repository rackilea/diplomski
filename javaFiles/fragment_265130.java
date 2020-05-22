package com.sbp;

import com.sbp.MyServiceTest.TestContext.MyService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Service;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class) // run with spring
@SpringBootTest(classes = MyServiceTest.TestContext.class) // make it a spring boot test so @MockBean annotation is processed, provide a dummy test context class
public class MyServiceTest {

    public interface Consumer<T, R> {

        public void unsubscribe();
    }

    @Configuration
    public static class TestContext {
        @Service
        public class KafkaConsumer implements Consumer<String, String> {

            @Override
            public void unsubscribe() {
            }

        }

        @Service
        public class MyService {

            @Autowired
            private Consumer<String, String> kafkaConsumer;

            public void clearSubscriptions() {
                kafkaConsumer.unsubscribe();
            }
        }
    }

    @MockBean // this will create a mockito bean and put it in the application context in place of the Kafka consumer bean defined in the TestContext class
    private Consumer<String, String> kafkaConsumer;

    @Autowired // inject the bean from the application context that is wired with the mock bean
    private MyService myService;

    @Test
    public void testClearSubscriptions() {
        myService.clearSubscriptions();
        Mockito.verify(kafkaConsumer, Mockito.times(1)).unsubscribe();
    }
}