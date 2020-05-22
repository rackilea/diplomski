String id = getIntent().getExtras.getString("id");
HashMap<String, String> hm = (Your database class Object).getDetails(id);
if(hm.size()>0){
  String value1 = hm.get(KEY);
// get all data and show according to you.
}