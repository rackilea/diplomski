public static String[] CreateVocab(BufferedReader buffR) throws IOException{
    List<String> lines = new ArrayList<String>();
    String line = null;
    while((line = buffR.readLine()) != null){
        lines.add(line);
    }
    return lines.toArray(new String[]{});     
}