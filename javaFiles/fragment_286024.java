import com.amazonaws.services.sqs.AmazonSQSClient
import com.amazonaws.services.sqs.model.SendMessageRequest  

val sqs = new AmazonSQSClient()

listOfObjects.foreach { obj =>
    val json = // convert obj to json

    sqs.sendMessage(new SendMessageRequest()
        .withQueueUrl("your queue url")
        .withMessageBody(json))
}