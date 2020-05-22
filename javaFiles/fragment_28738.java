Properties props = new Properties();
props.put(...);
KafkaConfig config = KafkaConfig.fromProps(props);
Seq<KafkaMetricsReporter> reporters = KafkaMetricsReporter$.MODULE$.startReporters(new VerifiableProperties(props));
KafkaServer server = new KafkaServer(config, new SystemTime(), Option.apply("prefix"), reporters);
server.startup();