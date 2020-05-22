Path inPath  = new Path("C:\\Users\\vaijnathp\\IdeaProjects\\MSExcel\\vaj");
Path outPath = new Path("getDestinationPath") ;
FileSystem fs = FileSystem.get(new Configuration());
FileStatus [] contents contents = fs.listStatus(inPath, new OutputLogFilter());
DataFileWriter<GenericRecord> writer = new DataFileWriter<>(new GenericDatumWriter<>());
Schema schema = null;
String inputCodec = null;
Map<String, byte[]> metadata = new TreeMap<>();
BufferedOutputStream output = new BufferedOutputStream(new BufferedOutputStream(fs.create(outPath)));
for (int i = 0; i < contents.length; i++) {
        FileStatus folderContent = contents[i];
        if (folderContent.isFile() && folderContent.getPath().getName().endsWith(".avro")) {
            InputStream input = new BufferedInputStream(fs.open(folderContent.getPath()));
            DataFileStream<GenericRecord> reader = new DataFileStream<>(input, new GenericDatumReader<GenericRecord>());
            if (schema == null) {
                schema = reader.getSchema();
               //extract metadata for further check.
                extractAvroFileMetadata(writer, metadata, reader);
                inputCodec = reader.getMetaString(DataFileConstants.CODEC);
                if (inputCodec == null) inputCodec = DataFileConstants.NULL_CODEC;
                writer.setCodec(CodecFactory.fromString(inputCodec));
                writer.create(schema, output);
            } else {
                if (!schema.equals(reader.getSchema())) reader.close();
                //compare FileMetadata with previously extracted one
                CompareAvroFileMetadata(metadata, reader, folderContent.getPath().getName());
                String thisCodec = reader.getMetaString(DataFileConstants.CODEC);
                if (thisCodec == null) thisCodec = DataFileConstants.NULL_CODEC;
                if (!inputCodec.equals(thisCodec)) reader.close();
            }
            writer.appendAllFrom(reader, false);
            reader.close();
        }
    }
 writer.close();
}catch (Exception e){
    e.printStackTrace();
}