JSONArray arr = new JSONArray();
for (int i = 0 ; i < hitsArray.length(); i++) {
    JSONObject jObject = hitsArray.getJSONObject(i);
    arr.put(jObject.get("_source"));         
}    

request.setAttribute("jsonObject", arr);
RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
dispatcher.forward(request, response);