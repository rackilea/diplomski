private void readFile(String file) {
    try {
        FileReader f = new FileReader(file);
        BufferedReader reader = new BufferedReader(f);
        String word = "";
        while ((word = reader.readLine()) != null) { 
            int length = word.length();
            if(setMap.containsKey(length)) {
                setMap.get(length).add(word);
            } else {
                Set set = new HashSet<String>();
                set.add(word); 
                setMap.put(length, set);
            }
        }

    } catch (Exception e) { //Done in case of an exception
        System.out.println("No file found.");
    }
}