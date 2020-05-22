try {
                    JSONArray _jArrayMain = new JSONArray("YOURJSONSTRING");
                    for (int i = 0; i < _jArrayMain .length(); i++) {
                        JSONObject _jObj = _jArrayMain.getJSONObject(i);
                        JSONObject   _jObjTarget = _jObj.getJSONObject("target");
                        String _indicator_name = _jObjTarget.getString("indicator_name");
                        System.out.println("Indicator Name : " + _indicator_name);
                    }
                } catch (JSONException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }