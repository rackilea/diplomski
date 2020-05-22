try {
    FileInputStream fis = new FileInputStream(myExternalFile);
    DataInputStream in = new DataInputStream(fis);
    BufferedReader br = new BufferedReader(new InputStreamReader(in));
    String strLine;
    while ((strLine = br.readLine()) != null) {
        myData = myData + strLine;
    }
    in.close();
} catch (IOException e) {
    e.printStackTrace();
}