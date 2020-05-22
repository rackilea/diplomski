public class MyClassFactory {

    public MyClass fromCsvLine(String csvLine) {
        String[] fields = StringUtils.split(csvLine, ',');
        return new MyClass(fields[3], fields[15], Integer.parseInt([fields[8]));
    }

    //...
}