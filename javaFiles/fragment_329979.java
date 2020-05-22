public static void main(final String[] args) {

final File file = new File("/home/chandra/Documents/dataExcelFiles/final.csv");
    file.getParentFile().mkdirs();
 Serializer serializer = CsvIOFactory.createFactory(TestClass.class,  TestClass2.class).createSerializer();

    TestClass testClass = new TestClass();

    testClass.getTestClass1().setId(1);
    testClass.getTestClass1().setName("HTC");
    testClass.getTestClass2().setOrderno(512);
    testClass.getTestClass2().setOrderName("HTC500");

    try {

        serializer.open(new FileWriter(file));
        serializer.write(testClass);
        serializer.close(true);

    } catch (IOException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
    }
}