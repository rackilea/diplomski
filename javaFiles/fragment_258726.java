import org.apache.kafka.clients.producer.KafkaProducer; 
import org.apache.kafka.clients.producer.ProducerConfig; 
import org.apache.kafka.clients.producer.ProducerRecord; 
... 
import java.util.Properties;
...
Properties props = new Properties(); 
props.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, 
          "172.31.22.7:9092,172.31.22.6:9092,172.31.22.5:9092,172.31.22.4:9092"); 
props.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, 
          "org.apache.kafka.common.serialization.ByteArraySerializer"); 
props.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, 
          "org.apache.kafka.common.serialization.ByteArraySerializer"); 
KafkaProducer<byte[], byte[]> producer = new KafkaProducer<>(props); 
...