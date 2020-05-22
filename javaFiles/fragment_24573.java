try(GZIPInputStream gzip = new GZIPInputStream(new FileInputStream(f));
     BufferedReader br = new BufferedReader(new InputStreamReader(gzip)))
 {
    br.readLine();
 }
 catch (IOException e) {
    e.printStackTrace();
 }