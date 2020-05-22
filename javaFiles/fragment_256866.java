try {
                        JSONArray jsonArray = response.getJSONArray("get_request");// this is your array containing data

                        for (int i=0;i<jsonArray.length();i++) {
                            JSONObject jobj = jsonArray.getJSONObject(i);

                            String id = jobj.getString("id");

                                String email_c =jobj.getString("pick_lat");
                                String pass_c = jobj.getString("pick_lon");

                                checkingDTO = new CheckingDTO(email_c+"=="+pass_c,email_c,pass_c,email_c,pass_c);

                                CheckingDTO check = new CheckingDTO(email_c+"=="+pass_c,email_c,pass_c,email_c,pass_c);
                                arrayList.add(check);
                        }
                    } catch (JSONException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }