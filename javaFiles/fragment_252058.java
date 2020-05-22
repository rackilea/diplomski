package net.lenthe;

import javax.jms.ConnectionFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.jms.config.DefaultJmsListenerContainerFactory;

@SpringBootApplication
public class JmsDemoApplication {

    @Autowired
    private ConnectionFactory connectionFactory;

    @Bean(name = "topicJmsListenerContainerFactory")
    public DefaultJmsListenerContainerFactory getTopicFactory() {
        DefaultJmsListenerContainerFactory f = new  DefaultJmsListenerContainerFactory();
        f.setConnectionFactory(connectionFactory);
        f.setSessionTransacted(true);
        f.setPubSubDomain(true);
        return f;
    }

    public static void main(String[] args) {
        SpringApplication.run(JmsDemoApplication.class, args);
    }
}