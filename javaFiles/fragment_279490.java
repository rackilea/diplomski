final String TEST_URL = "http://localhost:8181";
        AvroValue avroValue = new AvroValue();
        avroValue.setId(1);
        avroValue.setField(1);

        // Start creating and configuring the stream processing
        StreamsBuilder builder = new StreamsBuilder();

        myConfigFactory myConfigFactory = new myConfigFactory();
        myConfigFactory.setCdcChromeImageTopic("Topic1");

        myConfig myConfig = myConfigFactory.build();

        // call the code to be tested
        myBuilder myBuilder = new myBuilder(myConfig);
        myBuilder.initializeStreams(builder);

        Properties props = new Properties();
        props.setProperty(StreamsConfig.APPLICATION_ID_CONFIG, "kafka-unit-test");
        props.setProperty(StreamsConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9091");
        props.setProperty(StreamsConfig.DEFAULT_KEY_SERDE_CLASS_CONFIG,
                SpecificAvroSerde.class.getName());
        props.setProperty(StreamsConfig.DEFAULT_VALUE_SERDE_CLASS_CONFIG,
                SpecificAvroSerde.class.getName());
        props.setProperty(StreamsConfig.DEFAULT_TIMESTAMP_EXTRACTOR_CLASS_CONFIG,
                CustomTimestampExtractor.class.getName());
        props.setProperty(AbstractKafkaAvroSerDeConfig.SCHEMA_REGISTRY_URL_CONFIG, TEST_URL);
        this.config = new StreamsConfig(props);

        // Create the topology to start testing
        Topology topology = builder.build();
        ProcessorTopologyTestDriver driver =
                new ProcessorTopologyTestDriver(this.config, topology);

        final Map<String, String> serdeConfig = new HashMap<>();
        serdeConfig.put("schema.registry.url", TEST_URL);
        serdeConfig.put(AbstractKafkaAvroSerDeConfig.AUTO_REGISTER_SCHEMAS, "true");


        Serde<AvroKey> keyAvroSerde = new SpecificAvroSerde<>();
        keyAvroSerde.configure(serdeConfig, true); // `true` for record keys
        final Serde<AvroValue> valueAvroSerde = new SpecificAvroSerde<>();
        valueAvroSerde.configure(serdeConfig, false); // `false` for record values


        // Run a test with something that should pass the filter
        driver.process(myConfigFactory.getFirstTopic(), testKey,
                testValue, keyAvroSerde.serializer(),
                valueAvroSerde.serializer());

        ProducerRecord<myKey, dbo_my> recordPassesFilter =
                driver.readOutput(myConfigFactory.getOutTopic(),
                        keyAvroSerde.deserializer(),
                        valueAvroSerde.deserializer());

        ProducerRecord<OutAvroKey, OutAvroValue> recordOut =
                new ProducerRecord<>(myConfigFactory.getOutTopic(), null, 0L,
                        outKey, outValue);

        assertEquals("The filtered output keys didn't match", recordOut.key(),
                recordPassesFilter.key());
        assertEquals("The filtered output values didn't match", recordOut.value(),
                recordPassesFilter.value());
        keyAvroSerde.close();
        valueAvroSerde.close();
        process.destroy();
    } catch (Exception e) {
        fail(e);            
    }
}