Map<String, String> map = new TreeMap<>();

BufferedReader br = null;

try {
    String line;

    br = new BufferedReader(new FileReader("C:\\log.txt"));

    int counter = 0;
    while ((line = br.readLine()) != null) {
        String key = line.split("\\s+")[4];
        key = key + "-" + counter;
        map.put(key, line);
        ++counter;
    }
} catch (IOException e) {
    e.printStackTrace();
} finally {
    try {
        if (br != null) br.close();
    } catch (IOException ex) {
        ex.printStackTrace();
    }
}

// now you can iterate over the log statements in order by ID
for (Map.Entry<String,String> entry : map.entrySet()) {
    System.out.println(entry.getKey() + " => " + entry.getValue());
}