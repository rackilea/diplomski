for (int j = 0; j < X.size(); j++)
 {
  zBean aBean = (zBean)X.get(j);
  jsonObj = new JSONObject();
//^^^^^^^^^^^^^^^^^^^^^^^^^^^ add this line
  jsonObj.put(ID,newInteger(aBean.getId()));
  jsonObj.put(NAME,aBean.getName());
  jsonArray.add(jsonObj);
 }