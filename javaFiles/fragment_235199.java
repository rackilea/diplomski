JSONObject jParent=new JSONObject();
         JSONArray list = new JSONArray();
         try {
            for (Product p : boxAdapter.getBox()) {                  
              if (p.checked){
                JSONObject jChild=new JSONObject(); //Correction here   
                    jChild.put("uid", p.uid);
                list.add(jChild);        //Correction here                       

              }
            }
            jParent.put("users", list);    
           } catch (JSONException e) {
                    e.printStackTrace();
                }

            Log.v("TakeAttendance","JSONpARENT "+jParent); //Correction here