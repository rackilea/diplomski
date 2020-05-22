Collection<JSONObject> JSONObjects = new ArrayList<>();
try {
    FileReader fr = new FileReader("SelectedChoice.txt");
    BufferedReader br = new BufferedReader(fr);

    String zeile ="";

    while((zeile = br.readLine())!=null) {
        System.out.println(zeile);
        JSONObject choice = new JSONObject(zeile);
        System.out.println(choice);
        JSONObjects.add(choice);
    }

    br.close();
    fr.close();
} catch (FileNotFoundException e) {
    e.printStackTrace();
} catch (IOException e) {
    e.printStackTrace();
}