if (jsonObject.has("results")) {
                    JSONArray resultArray = jsonObject.getJSONArray("results");                 
                    for (int i=0;i<resultArray.length();i++) {
                        JSONObject resultObj = resultArray.getJSONObject(i);
                        if(resultObj.has("values")){
                            JSONArray valuesArray= resultObj.getJSONArray("values");
                            for(int j=0; j<valuesArray.length();j++){
                            JSONObject jObj = valuesArray.getJSONObject(j);
                            System.out.println(j+"  "+"Date: " + jObj.getString("id"));
                            System.out.println(j+"  "+"Volume: " + jObj.getInt("value"));
                            }
                        }
                    }

                }