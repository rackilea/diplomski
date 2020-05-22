import com.rabbitmq.client.Channel;
import org.springframework.amqp.support.AmqpHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class Receiver {
    @RabbitListener(queues = "my-messages")
    public void receiveMessage(String payload, Channel channel, @Header(AmqpHeaders.DELIVERY_TAG) long deliveryTag) throws IOException {
        System.out.println("Received message: `" + payload + "`, deliveryTag: " + deliveryTag);
        channel.basicNack(deliveryTag, false, true);
    }
}