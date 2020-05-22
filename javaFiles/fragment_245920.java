final Schema schema = new Schema.Parser().parse(new File("sample.avsc"));            
        File file ="sample.avro"

        //read the avro file to GenericRecord
        final GenericDatumReader<GenericRecord> genericDatumReader = new GenericDatumReader<>(schema);
        final DataFileReader<GenericRecord> genericRecords = new DataFileReader<>(file, genericDatumReader);

        //serialize GenericRecords
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        DatumWriter<GenericRecord> writer = new GenericDatumWriter<GenericRecord>(schema);

        Encoder binaryEncoder = EncoderFactory.get().binaryEncoder(out, null);

        while (genericRecords.hasNext()) {
            writer.write(genericRecords.next(), binaryEncoder);
        }
        binaryEncoder.flush();
        out.close();
       //send out.toByteArray() to kakfa