public void getCsv() throws FileNotFoundException {

    String fileName = "ADCSV.csv";
    File file = new File(fileName);

    Scanner inputStream = new Scanner(file);

    while (inputStream.hasNext()) {

        String data = inputStream.next();

        // array of strings
        String[] values = data.split(",");
        if (values.length < 5) {
            System.err.println("not enough values: ");
            for (int i = 0; i < values.length; i++) {
                System.err.println("value " + i + ": " + values[i]);
            }
            continue;
        }
        System.out.println(values[4]);

    }

    inputStream.close();

}