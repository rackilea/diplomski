String sCurrentLine = new String();
 reader = new BufferedReader(new 
                FileReader("/Users/FakeUsername/Desktop/GroceryList.txt"));
 while ((sCurrentLine = reader.readLine() != null) {
    String words[] = sCurrentLine.split(" ");
    System.out.println(words[0]+" "+words[1]);
 }