public static LinkedHashMap<String, ArrayList<String>> runningOrderMap(String filename) throws IOException {
    LinkedHashMap<String, ArrayList<String>> linkedHashMap = new LinkedHashMap<>(50);
    String currentLine = ""; //init iterator variable
    String[] valuesTMP;
    try {
        bufferedReader = new BufferedReader(new FileReader(filename));
    } catch (FileNotFoundException e) {
        e.printStackTrace();
    }
    while((currentLine = bufferedReader.readLine()) != null){
        valuesTMP = currentLine.split(", ");
        ArrayList<String> values = new ArrayList<>();
        String key = valuesTMP[0].split("\t")[0].trim();
        values.add(valuesTMP[0].split("\t")[1].trim());
        for(int i = 1; i < valuesTMP.length; i++){
            values.add(valuesTMP[i]);
            System.out.println(valuesTMP[i]);
        }
        linkedHashMap.put(key, values); // <--this line was moved out from internal for loop
    }
    System.out.println("linked hashmap:"+linkedHashMap.keySet().size());
    return linkedHashMap;
}