Scanner br = new Scanner(new FileReader("file2"));
HashMap map = new HashMap();
String line;
String temp2;
while (br.hasNextLine()) {
    line = br.nextLine();
    Scanner scan = new Scanner(new FileReader("file1"));
    while (scan.hasNextLine()) {
        temp2 = (String) scan.nextLine();
        if (temp2.equals(line)) {
            //Scanner scn = new Scanner(temp2);
            String string;
            while (scan.hasNext() && ((string = scan.next()) != "\n")) {
                String[] temp3 = string.split("=");
                if (temp3.length > 1) {
                    String key = temp3[0];
                    String value = temp3[1];
                    map.put(key, value);// TODO code application logic
                                        // here
                }
            }
        }
    }
}
Set set = map.entrySet();
Iterator iter = set.iterator();
while (iter.hasNext()) {
    Map.Entry maps = (Map.Entry) iter.next();
    String key = (String) maps.getKey();
    String value = (String) maps.getValue();
    System.out.println("key:" + key + " value" + value);
}