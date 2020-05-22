Log.i("jsonData", jsonData);
            try{
            JSONObject jobj1=new JSONObject(jsonData);
            for(int i=0;i<31;i++){
                if(jobj1.has(""+i)){
                    JSONObject jobj2=jobj1.getJSONObject(""+i);
                    fazarData.add(jobj2.getString("fajr"));
                }
            }

            Log.i("fajr", ""+fazarData);

            }catch (Exception e) {
                // TODO: handle exception
                e.printStackTrace();
            }
        }