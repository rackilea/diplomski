package com.sbp;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@RunWith(MockitoJUnitRunner.class) // run with mockitos runner so annotations are processed
public class MyServiceTest {

    public interface Consumer<T, R> {

        public void unsubscribe();
    }

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

    @Mock // tell mockito that this is a mock class - it will instantiate for you
    private Consumer<String, String> kafkaConsumer;

    @InjectMocks // tell mockito to inject the above mock into the class under test
    private MyService service = new MyService();

    @Test
    public void testClearSubscriptions() {
        service.clearSubscriptions();
        Mockito.verify(kafkaConsumer, Mockito.times(1)).unsubscribe();
    }
}