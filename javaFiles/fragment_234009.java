File dir = new File("C:\\Users\\Mahady\\Desktop\\Java 31122011\\src\\register\\");
for (string fn : dir.list()) {
    FileInputStream fstream = new FileInputStream(fn);
    DataInputStream in = new DataInputStream(fstream);
    BufferedReader br = new BufferedReader(new InputStreamReader(in));
    String strLine;
    while ((strLine = br.readLine()) != null)   {
        System.out.println (strLine);
    }
    in.close();
}