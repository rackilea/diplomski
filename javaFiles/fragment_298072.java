package demo;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageChannel;
import org.springframework.stereotype.Service;

@Service
public class MyService {

    private final Map<String, MessageChannel> channels;

    @Autowired
    public MyService(Map<String, MessageChannel> channels) {
        super();
        this.channels = channels;
    }

    public void transformAndRoute(Message<?> in) {
        // do your business logic here
        Message<?> out = MessageBuilder.fromMessage(in).build();

        // if(something)...
        channels.get("fooChannel").send(out);
    }

}