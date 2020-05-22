public class ConfluentAvroDeserializationSchema
            implements DeserializationSchema<GenericRecord> {

        private final String schemaRegistryUrl;
        private final int identityMapCapacity;
        private transient KafkaAvroDecoder kafkaAvroDecoder;


        public ConfluentAvroDeserializationSchema(String schemaRegistyUrl) {
            this(schemaRegistyUrl, 1000);
        }

        public ConfluentAvroDeserializationSchema(String schemaRegistryUrl, int
                identityMapCapacity) {
            this.schemaRegistryUrl = schemaRegistryUrl;
            this.identityMapCapacity = identityMapCapacity;
        }

        @Override
        public GenericRecord deserialize(byte[] bytes) throws IOException {
            if (kafkaAvroDecoder == null) {
                SchemaRegistryClient schemaRegistry = new
                        CachedSchemaRegistryClient(this.schemaRegistryUrl,
                        this.identityMapCapacity);
                this.kafkaAvroDecoder = new KafkaAvroDecoder(schemaRegistry);
            }
            return (GenericRecord) this.kafkaAvroDecoder.fromBytes(bytes);
        }

        @Override
        public boolean isEndOfStream(GenericRecord string) {
            return false;
        }

        @Override
        public TypeInformation<GenericRecord> getProducedType() {
            return TypeExtractor.getForClass(GenericRecord.class);
        }
    }