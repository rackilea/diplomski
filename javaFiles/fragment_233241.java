public class Sort {


private static class Counter {

    private int one;
    private int mixed;

    public void incrementOne() {
        one++;
    }

    public void incrementMixed() {
        mixed++;
    }
}

public static void main(String[] args) throws IOException {
    Map<String, Counter> map = new LinkedHashMap<String, Counter>();
    String fileName = "input.txt";
    BufferedReader reader = new BufferedReader(new FileReader(fileName));

    for (String line = reader.readLine(); line != null; line = reader.readLine()) {
        StringTokenizer tokenizer = new StringTokenizer(line);
        String key = tokenizer.nextToken();
        String value = tokenizer.nextToken();
        Counter counter = map.get(key);
        if (counter == null) {
            counter = new Counter();
            map.put(key, counter);
        }
        if (value.equals("1")) {
            counter.incrementOne();
        } else {
            counter.incrementMixed();
        }
    }
    reader.close();
    BufferedWriter writer = new BufferedWriter(new FileWriter("output.txt"));
    for(Map.Entry<String, Counter>entry:map.entrySet()){
        Counter counter = entry.getValue();
        if(counter.one>0){
            writer.write(String.valueOf(counter.one));
            writer.write(" x ");
            writer.write(entry.getKey());
            writer.write("   1");
            writer.newLine();
        }
        if(counter.mixed>0){
            writer.write(String.valueOf(counter.mixed));
            writer.write(" x ");
            writer.write(entry.getKey());
            writer.write("   MIXED");
            writer.newLine();
        }
    }
    writer.close();

}