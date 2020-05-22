List<HashMap<String,String>> tbcPackages = new 
ArrayList<HashMap<String,String>>();

for(int i = 0; i <5 ; i++){
  JSONObject g = new JSONObject();
  g.clear();

  System.out.println("clear? : " + g);

  g.put("test", i);

  tbcPackages.add(g); 
  System.out.println(tbcPackages);
}