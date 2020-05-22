package test;

import com.amazonaws.auth.AWSCredentialsProvider;
import com.amazonaws.regions.AwsRegionProvider;
import com.amazonaws.services.sqs.AmazonSQSAsync;
import com.amazonaws.services.sqs.AmazonSQSAsyncClientBuilder;
import test.TestDto;
import test.CustomQueueMessageHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.aws.messaging.config.SimpleMessageListenerContainerFactory;
import org.springframework.cloud.aws.messaging.config.annotation.NotificationMessage;
import org.springframework.cloud.aws.messaging.config.annotation.NotificationSubject;
import org.springframework.cloud.aws.messaging.listener.SimpleMessageListenerContainer;
import org.springframework.cloud.aws.messaging.listener.SqsMessageDeletionPolicy;
import org.springframework.cloud.aws.messaging.listener.annotation.SqsListener;
import org.springframework.stereotype.Component;

@Component
public class TestQueue {

  private static final String QUEUE_NAME = "TestQueue";
  private static final Logger log = LoggerFactory.getLogger(TestQueue.class);

  public TestQueue(AWSCredentialsProvider credentialsProvider, AwsRegionProvider regionProvider) {
    AmazonSQSAsync client = AmazonSQSAsyncClientBuilder.standard()
        .withCredentials(credentialsProvider)
        .withRegion(regionProvider.getRegion())
        .build();

    // custom QueueMessageHandler to initialize only this queue
    CustomQueueMessageHandler queueMessageHandler = new CustomQueueMessageHandler();
    queueMessageHandler.init(this);
    queueMessageHandler.afterPropertiesSet();

    SimpleMessageListenerContainerFactory factory = new SimpleMessageListenerContainerFactory();
    factory.setAmazonSqs(client);
    factory.setQueueMessageHandler(queueMessageHandler);

    SimpleMessageListenerContainer simpleMessageListenerContainer = factory.createSimpleMessageListenerContainer();
    simpleMessageListenerContainer.setMessageHandler(queueMessageHandler);
    try {
      simpleMessageListenerContainer.afterPropertiesSet();
    } catch (Exception e) {
      throw new RuntimeException(e);
    }
    simpleMessageListenerContainer.start();
  }

  @SqsListener(value = QUEUE_NAME, deletionPolicy = SqsMessageDeletionPolicy.ON_SUCCESS)
  public void receiveMessage(@NotificationMessage TestDto dto, @NotificationSubject String subject) {
    log.info("Received SQS Message: \nSubject: {} \n{}", subject, dto);
  }
}