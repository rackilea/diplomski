@Override
    public void write(OutputStream output) throws IOException, WebApplicationException {
        try(BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(output))){
            StatefulBeanToCsvBuilder builder = new StatefulBeanToCsvBuilder(writer);
            StatefulBeanToCsv beanWriter = builder
                    .withSeparator(';').build();
            try {
                beanWriter.write(this.inputData.iterator());
                writer.flush();
            } catch (CsvDataTypeMismatchException | CsvRequiredFieldEmptyException  e) {
                throw new CMMV1Exception("Failed to download admin file");
            }
        }

    }