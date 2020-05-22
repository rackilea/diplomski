public static void main(String[] args) throws IOException, JSONException {
        Schema schema = new Schema.Parser()
           .parse("{ \"type\":\"record\", \"name\":\"new_user\", \"namespace\":\"com.hello\", \"fields\":[ { \"name\":\"user_id\", \"type\":[ \"long\", \"null\" ] }, { \"name\":\"segment\", \"type\":[ \"string\", \"null\" ] } ] }");

        // create example record
        GenericRecord record = new GenericData.Record(schema);
        record.put("user_id", 123456L);
        record.put("segment", "hello");

        // serialize record
        byte[] recordData = getAvroBinaryData(schema, record);

        // de-serialize byte array to record  
        GenericRecord readRecord = readRecord(schema, recordData);

        // increment user_id field
        Long userId = (Long) readRecord.get("user_id");
        readRecord.put("user_id", userId + 1);

        // prints 123457 for the user_id
        System.out.println(readRecord);

        // serialize updated recored
        byte[] updatedRecordData = getAvroBinaryData(schema, readRecord);

        // do something with updatedRecordData
    }   

    private static GenericRecord readRecord(Schema schema, byte[] originalAvrodata) throws IOException {
        Decoder decoder = DecoderFactory.get().binaryDecoder(originalAvrodata, null);       
        DatumReader<GenericRecord> reader = new GenericDatumReader<GenericRecord>(schema);
        GenericRecord readRecord = null;

        try {
            readRecord = reader.read(null, decoder);            
        } catch (EOFException eofe) {
            eofe.printStackTrace();
        }

        return readRecord;
    }

    // takes the record to be serialized as an additonal parameter
    private static byte[] getAvroBinaryData(Schema schema, GenericRecord record) throws IOException {
        GenericDatumWriter<GenericRecord> writer = new GenericDatumWriter<GenericRecord>(schema);
        ByteArrayOutputStream os = new ByteArrayOutputStream();
        Encoder e = EncoderFactory.get().binaryEncoder(os, null);
        writer.write(record, e);
        e.flush();
        byte[] byteData = os.toByteArray();
        return byteData;
    }