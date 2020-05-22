public static class AvroMapper extends Mapper<AvroKey<GenericData.Record>, NullWritable, AvroKey<GenericData.Record>, NullWritable> {

        @Override
        public void map(AvroKey<GenericData.Record> key, NullWritable value, Context context) throws IOException, InterruptedException {

            try {
                System.out.println("Specific Record - " + key);
                System.out.println("Datum :: " + key.datum());
                System.out.println("Schema :: " + key.datum().getSchema());
                List<Field> fields = key.datum().getSchema().getFields();

                Schema s = Schema.createRecord(key.datum().getSchema().getName(), null, key.datum().getSchema().getNamespace(), false);
                List<Field> outFields  = new ArrayList<Field>();
                for(Field f : fields) {
                    System.out.println("Field Name - " + f.name());
                    Schema.Field f1 = new Schema.Field(f.name(),Schema.create(Schema.Type.STRING), null,null);
                    outFields.add(f1);
                }
                s.setFields(outFields);

                System.out.println("Out Schema - " + s);
                GenericData.Record record = new GenericData.Record(s);
                for(Field f : fields) {
                    record.put(f.name(), key.datum().get(f.name()));
                }
                System.out.println("Record - " + record);
                AvroKey<GenericData.Record> outkey = new AvroKey<GenericData.Record>(record);
                System.out.println("Generic Record (Avro Key) - " + outkey.datum());
                context.write(outkey, NullWritable.get());
            } catch (Exception e) {
                e.printStackTrace();
                System.out.println(e);
                System.out.println(e.getMessage());
                throw new IOException(e.getMessage());
            }
        }
    }