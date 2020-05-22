package com.example.udp;

import org.springframework.messaging.Message;

public class UDPConsumer {

    @Autowire what you want, this will be a Spring Bean

    @ServiceActivator
    public void consume(Message message) {
         ... do something with message ...
    }
}