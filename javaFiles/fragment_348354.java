public static String ReadTextFile(String path) throws IOException{
    String HoldsText= null;

    InputStream is = getClass().getResourceAsStream(path);
    InputStreamReader fr = new InputStreamReader(is);
    BufferedReader br = new BufferedReader(fr);

    StringBuilder sb = new StringBuilder();
    while((HoldsText = br.readLine())!= null){
        sb.append(HoldsText)
        .append("\n");
    }

    return sb.toString();
}