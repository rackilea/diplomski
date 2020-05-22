private byte[] buildAvroData(String name, byte[] data) throws IOException
{       
    out.reset(); 
    GenericRecord datum=new GenericData.Record(avroSchema);        
    datum.put("name", name);
    datum.put("data",ByteBuffer.wrap(data));
    DatumWriter<GenericRecord> writer=new GenericDatumWriter<>(avroSchema);        
    writer.write(datum,encoder);
encoder.flush();
    return out.toByteArray();