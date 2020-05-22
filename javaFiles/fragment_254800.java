JSONObject mainObj = new JSONObject();
    JSONArray somearr = new JSONArray();
                        while (iter.hasnext()) {
                             ClassName someObject=iter.next();
                            JSONObject jsonobj = new JSONObject();
                            jsonobj.put("id", id_from_someObject);;
                            jsonobj.put("name", name_from_someObject);
                            jsonobj.put("name", location_from_someObject);;

                        somearr.put(seatObj);

                        }

mainObj.put("response",somearr);

return mainObj.toString();