public static void main(String args[]) throws IOException {
    Map<String, String> sections = new HashMap<>();
    List<String> content = (List<String>)Files.lines(Paths.get("files/input.txt")).collect(Collectors.toList());
    String lastKey = "";
    for(String s : content){
        String k = s.substring(0, 10).trim(); 
        String v = s.substring(10, s.length()-9).trim();
        if(k.equals(""))
            k=lastKey;
        sections.merge(k, v, String::concat);
        lastKey=k;
    }
    System.out.println(sections.get("TITLE"));
}