import org.apache.kafka.clients.consumer.KafkaConsumer
import org.apache.kafka.common.TopicPartition

import collection.mutable.ArrayBuffer
import collection.JavaConverters._

//initialise consumer:
val consumer = createKafkaConsumer(config, subscriptions) // Make this a val!

//accept a scala.collection.mutable.ArrayBuffer here
def commitSync(offsets: ArrayBuffer[TopicPartition]) = {
  //and then convert it to a java
  consumer.resume(offsets.asJava)
}