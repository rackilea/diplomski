class ReverseTemplateEngine {
   ArrayList<String> prefixes = new ArrayList();
   ArrayList<String> suffixes = new ArrayList();

   public ReverseTemplateEngine(String... templates) {
     for (String s: templates) {
       int cut = s.indexOf("$");
       suffixes.add(s.substring(0, cut));
       prefixes.add(s.substring(cut + 1);
     }
   }

   public List<String> parse(BufferedReader r) {
     ArrayList<String> result = new ArrayList<>();
     while (true) {
       String line = reader.readLine();
       for (int i = 0; i < prefixes.length; i++) {
         if (line.startsWith(prefixes.get(i)) 
             && line.endsWith(suffixes.get(i)) {
           result.add(line.substring(prefixes.get(i).length(),
                      line.length() - suffixes.get(i).length()));
           break;
         }
       }
     }
     return list;
   }
 }