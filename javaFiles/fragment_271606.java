public static void main(String args[]) {
    Map<String, String> sections = new HashMap<>();
    String s = "", lastKey="";
    try (BufferedReader br = new BufferedReader(new FileReader("files/input.txt"))) {
        while ((s = br.readLine()) != null) {
            String k = s.substring(0, 10).trim();
            String v = s.substring(10, s.length() - 9).trim();
            if (k.equals(""))
                k = lastKey;
            if(sections.containsKey(k))
                v = sections.get(k) + v; 
            sections.put(k,v);
            lastKey = k;
        }
    } catch (IOException e) {
        System.err.println("The file could not be found or read");
    }

    System.out.println(sections.get("TITLE"));
}