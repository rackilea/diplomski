Gson gson = new Gson();
Revision revision = new Revision();

HashMap<String, List<HashMap<String, String>>> HM = new HashMap<String, List<HashMap<String, String>>>();
List<HashMap<String, String>> list = new ArrayList<HashMap<String, String>>();
HashMap<String, String> HMin = new HashMap<String, String>();

HMin.put("id", "12");
HMin.put("type", "toster");
list.add(HMin);
HM.put("mark", list);

revision.setRev(HM);
revision.setAuth("ololo");

String json = gson.toJson(revision);

Revision test = new Gson().fromJson(json, Revision.class);

System.out.println(json);
System.out.println(revision);
System.out.println(test);