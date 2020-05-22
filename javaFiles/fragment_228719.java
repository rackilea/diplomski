ArrayList<List<String>> allLines = new ArrayList<List<String>>();
while ((sCurrentLine = br.readLine()) != null) {
    allLines.add(Arrays.asList(sCurrentLine.split("\\s+")));
    Collections.shuffle(allLines);
    for (List<String> s : allLines) {
        Collections.shuffle(s);
        for (String split : s) {
            if(split.matches("\\d*"))
            System.out.println(split);
        }
    }
}