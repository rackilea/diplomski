String[] ImpData = null;
try {
    String str;
    List<String> allStrings = new LinkedList<String>();
    BufferedReader br = new BufferedReader(new FileReader("imp.txt"));
    while ((str = br.readLine()) != null) {
        allStrings.add(str);
    }
    br.close();
    String[][] ImpData = new String[allStrings.size()][];
    for(int i=0; i<allStrings.size();i++){
        ImpData[i] = allStrings.get(i).split(" ");
    }

} catch (IOException exc) {
    System.out.println("IO error!" + exc);
}