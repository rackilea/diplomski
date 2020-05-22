JSONArray arr = new JSONArray(request.getParameter("mydata"));
List<String> jsonList = new ArrayList<String>();
for (int i = 0; i < arr.length(); i++) {
    jsonList.add(arr.getJSONObject(i).getString("invoice"));
}
String[] invoices = jsonList.toArray(new String[0]);