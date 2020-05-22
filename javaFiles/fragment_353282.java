public void convert(String filename) throws FileNotFoundException,
        IOException {
    List<String> list = new ArrayList<String>();
    BufferedReader reader = null;
    try {
        reader = new BufferedReader(new FileReader(filename));
        String s = reader.readLine();
        while (s != null) {
            // should work in this loop
            String s1 = s.replaceAll("\\p{Punct}|\\d","").toLowerCase();
            list.add(s1.toString());

        }
    } finally {
        if (reader != null)
            reader.close();
    }

    for (String s : list) {
        // will not work in this loop
        //String s1 = s.replaceAll("\\p{Punct}|\\d","").toLowerCase();
    //  list.add(s1.toString());

        System.out.println(s);
    }
}