JSONArray jsa = new JSONArray();
for (int i = 1; i<= 20; i++) {
  JSONObject cust = new JSONObject();
  cust.put("number",String.valueOf(i));
  cust.put("name","customer"+i);
  cust.put("url","url"+i);
  jsa.put(cust);
}
System.out.println(jsa.toString());