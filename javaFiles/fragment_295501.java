public static void main(String[] args) throws IOException {
        String[] modStrings = new String[] { "Item1", "Item2", "Item3", "Item4", "Item5" };
        FileReader reader = new FileReader("html.html");
        BufferedReader br = new BufferedReader(reader);
        String line;
        String[] tempContent = {};
        ArrayList content = new ArrayList();
        HashMap<String, String> modMap = new HashMap<>();
        while ((line = br.readLine()) != null) {
        if (line.contains("<br>")) {
            line = line.substring(line.indexOf("Item1"));
            tempContent = line.split("<br>");
            for (String item : tempContent) {
                if (item.contains("Item")) {
                    String[] itemArr = item.trim().split(" ", 2);
                    String itemName = itemArr[0].trim();
                    String value = itemArr[1].trim();
                    modMap.put(itemName, value);
                }
            }
        }
        }
        for(String key : modMap.keySet()){
            System.out.println(key + ":" + modMap.get(key));
        }
    }