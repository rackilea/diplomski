Pattern nom = Pattern.compile("\\b(unit|device|method|module|material|process|system)\\b");

String str = null;
BufferedReader r = new BufferedReader(new FileReader("D:/test/test1.txt"));
Map<String, Integer> counts = new HashMap<>();

while ((str = r.readLine()) != null) {
    Matcher matcher = nom.matcher(str);

    while (matcher.find()) {
        String key = matcher.group(1);
        int c = 0;
        if (counts.containsKey(key))
            c = counts.get(key);
        counts.put(key, c+1)
    }
}
r.close();

System.out.println(counts);