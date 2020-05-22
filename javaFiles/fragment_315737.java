class KafkaCustomSink(val config: Config) extends ForeachWriter[String] {
  var producer: KafkaProducer[String, String] = _
  var _version: Long = _

  override def open(partitionId: Long, version: Long): Boolean = {
    _version = version
    val props = new Properties()
    props.put("bootstrap.servers", config(Constant.OUTPUT_BOOTSTRAP_SERVER))
    props.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer")
    props.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer")
    props.put("acks", "0")
    producer = new KafkaProducer[String, String](props)
    true
  }

  override def process(value: String): Unit = {
    //use version here
    val record = new ProducerRecord[String, String](config(Constant.OUTPUT_TOPIC), null, "version : %s, data : %s".format(_version, value))
    producer.send(record)
  }

  override def close(errorOrNull: Throwable): Unit = {
    producer.close()
  }
}