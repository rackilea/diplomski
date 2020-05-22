public static String slurp(InputStream is){
    BufferedReader br = new BufferedReader(new InputStreamReader(is));
    StringBuilder sb = new StringBuilder();
    String line;
    while ((line = br.readLine()) != null) {
        sb.append(line+"\n");
    }
    br.close();
    return sb.toString();
 }