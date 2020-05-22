List<Map<String, String>> DataStruct = new ArrayList<Map<String, String>>();

JSONObject jSONObject = new JSONObject(Result);             
                    JSONArray entriesArr = jSONObject.getJSONArray("entries");
                    ItemsThisPage = entriesArr.length();
                      for (int i=0; i<ItemsThisPage; i++)
                      {
                          // FOR EACH ENTRY
                          JSONObject OneEntry = entriesArr.getJSONObject(i);
                          int OneEntrySize = OneEntry.length();
                          JSONArray EntKey = OneEntry.names(); 
                           Map<String, String> JsonItem = new HashMap<String, String>();
                          for (int j=0; j<OneEntrySize;j++)
                          {   // FOR EACH ITEM IN AN ENTRY
                              EntVal = EntKey.getString(j);
                              GenCell = OneEntry.opt(EntVal).toString();
                              JsonItem.put(EntVal, GenCell);            
                          }                       
                          DataStruct.add(JsonItem);                 
                      }    // end page loop