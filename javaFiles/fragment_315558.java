try {
    FileReader  files = new FileReader(file);
    BufferedReader buf = new BufferedReader(files);                
    String line = null; 
    String tokens[] = null;
    int count = 0;
    while ((line = buf.readLine()) != null) { 
        tokens = line.split("\\p{javaWhitespace}+");
        Vector<Object> row = new Vector<>();
        row.add(count);
        count++;
        for (String text: tokens) {
            row.add(text);
        }
        model.addRow(row); // add the Vector, not the tokens array
    } 
}