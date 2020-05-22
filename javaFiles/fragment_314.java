public class Tester {
public static Multiset<String> getMultisetFromCSV(String csvFileName, String lineDelimiter) throws IOException {
    Multiset<String> mapper = TreeMultiset.create();


    BufferedReader reader = null;

    try {
        reader = new BufferedReader(new FileReader(csvFileName));

        String[] currLineSplitted;

        while(reader.ready()) {
            currLineSplitted = reader.readLine().split(lineDelimiter);
            mapper.add(currLineSplitted[0] + "-" + currLineSplitted[1]);
        }

        return mapper;
    } finally {
        if(reader != null)
            reader.close();
    }

}

public static void main(String[] args) throws IOException {
    Multiset<String> set = getMultisetFromCSV("csv", ",");

    for(String key : set.elementSet()) {
        System.out.println(key + " : " + set.count(key));
    }


}