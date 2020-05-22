parser.addTypeHint("Example[]", Example.class);
 Map<String,List<Example>> result1 = parser.parse(Map.class, json);
 for (Entry<String, List<Example>> entry : result1.entrySet()) {
     for (Example example : entry.getValue()) {
          System.out.println("VALUE :->"+ example.getFoo());
     }
 }