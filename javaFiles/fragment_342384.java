public static void main(String[] args) throws Exception {
    String trimm = "ABC 123|1|2 ABC '123|1|2|\"Jan 30 2018  2:34:13:000AM\"|dd1|1|\"Jan 30 2018  2:56:08:000AM\"|EST' ABC 20180821\n" +
            "ABC 123|1|2 ABC '123|1|2|\"Jan 30 2018  2:34:13:000AM\"|dd1|1|\"Jan 30 2018  2:56:08:000AM\"|EST' ABC 20180821\r\n";

    try {
        File fout = new File("path");
        FileOutputStream fos = new FileOutputStream(fout);
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(fos));
        trimm = trimm.replaceAll("[\n\r]+$", "");
        bw.write(trimm);
        //bw.newLine();//<-----------------------note this
        bw.close();
    } catch (FileNotFoundException e) {
        // File was not found
        e.printStackTrace();
    } catch (IOException e) {
        // Problem when writing to the file
        e.printStackTrace();
    }
}