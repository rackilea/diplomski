JSONArray ja =jso.getJSONArray("Available");





            for (int i = 0; i < ja.length(); i++) {
                JSONObject jobj=ja.getJSONObject(i);
                xyz[i]=jobj.getString("date");
                abcd[i]=jobj.getJSONArray("timings").tostring;


            }


            }