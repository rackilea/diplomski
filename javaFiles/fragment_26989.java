JSONObject obj = new JSONObject();
JSONArray arr = new JSONArray();

for(int i = 0 ; i< list.size() ; i++)
{
    p = list.get(i);

    obj.put("id", p.getId());
    obj.put("title", p.getTitle());
    obj.put("date". new MyDateFormatter().getStringFromDateDifference(p.getCreationDate()));
    obj.put("txt", getTrimmedText(p.getText()));

    arr.put(obj);

    obj = new JSONObject();
}