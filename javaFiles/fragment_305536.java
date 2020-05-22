JSONObject responseDetailsJson = new JSONObject();
List<JSONObject> list = new ArrayList<JSONObject>();
System.out.println(form.size());
// List.get will be very inefficient if passed a LinkedList 
// instead of an ArrayList.
for (Form formInstance:form) {
       JSONObject formDetailsJson = new JSONObject();
       formDetailsJson.put("form_id", formInstance.getId());
       formDetailsJson.put("form_name", formInstance.getName());
       formDetailsJson.put("desc", 
                            formInstance.getFormDescription());
       list.add(formDetailsJson);
}

responseDetailsJson.put("form", list);