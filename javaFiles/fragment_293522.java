.....
JSONArray array = new JSONArray();
for(String fn : files) {
    //create json object for each file
    JSONObject data= new JSONObject();
    System.out.println(fn);
    data.put("file", fn);
    System.out.println(data);
    //put json object into json array
    array.put(data); 
}
view.setAttribute("file", array);
view.printJSON();