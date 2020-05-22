fIn = new FileInputStream(Paths.get(path).toString());

reader = new BufferedReader(new InputStreamReader(fIn));

csvToBean = new CsvToBeanBuilder(reader)
        .withType(MyBean.class)
        .withIgnoreLeadingWhiteSpace(true)
        .build();

it = csvToBean.iterator();

while (it.hasNext()) {
    MyBean csvData = it.next();

    // blabla ...
}

fIn.getChannel().position(0);

reader = new BufferedReader(new InputStreamReader(fIn));

csvToBean = new CsvToBeanBuilder(reader)
        .withType(MyBean.class)
        .withIgnoreLeadingWhiteSpace(true)
        .build();

it = csvToBean.iterator(); // <<<<<< NOT FAILING HERE