try{
    FileInputStream fstream = new FileInputStream("textfile.txt");
    DataInputStream in = new DataInputStream(fstream);
    BufferedReader br = new BufferedReader(new InputStreamReader(in));
    String strLine;
    while ((strLine = br.readLine()) != null) {
        if (strLine.contains("ADD_FLIGHT")) {
            System.out.println (strLine.replace("ADD_FLIGHT",""));
        } 
    }
    in.close();
}catch (Exception e){//Catch exception if any
    System.err.println("Error: " + e.getMessage());
}