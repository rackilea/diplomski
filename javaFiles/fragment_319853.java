JavaPairRDD tarData = sparkContext.binaryFiles("D:/sample_datasets/gzfiles/*.tar.gz");
JavaRDD tarRecords = tarData.flatMap(new FlatMapFunction, Row>(){
    private static final long serialVersionUID = 1L;

    @Override
    public Iterator call(Tuple2 t) throws Exception {
        TsvParserSettings settings = new TsvParserSettings();
        TsvParser parser = new TsvParser(settings);

        List records = new ArrayList();
        TarArchiveInputStream tarInput = new TarArchiveInputStream(new GzipCompressorInputStream(t._2.open()));
        TarArchiveEntry entry;
        while((entry = tarInput.getNextTarEntry()) != null) {
            if(entry.getName().equals("file1.csv")) {
                InputStreamReader streamReader = new InputStreamReader(tarInput);
                BufferedReader reader = new BufferedReader(streamReader);
                String line;

                while((line = reader.readLine())!= null) {
                    String [] parsedLine = parser.parseLine(line);
                    Row row = RowFactory.create(parsedLine);

                    records.add(row);
                }

                reader.close();
                break;
            }
        }
        tarInput.close();
        return records.iterator();
    }

});