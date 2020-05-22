try {
                    JSONObject _jObject  = new JSONObject("YOUR_JSON_STRING");
                    JSONObject _jObjectSub  = _jObject.getJSONObject("0");
                    int _id = _jObjectSub.getInt("id");
                    String _name = _jObjectSub.getString("name");
                    int _user_id = _jObjectSub.getInt("user_id");
                    String _created_at = _jObjectSub.getString("created_at");
                    String _updated_at = _jObjectSub.getString("updated_at");
                    JSONObject _users = _jObjectSub.getJSONObject("users");
                    int _idUsers = _users.getInt("id");
                    String _nameUsers = _users.getString("name");
                    String _lastNameUsers = _users.getString("last_name");
                    String _emailUsers = _users.getString("email");
                    String _cell_noUsers = _users.getString("cell_no");
                    String _genderUsers = _users.getString("gender");
                    int _countryUsers = _users.getInt("country");
                    String _nickUsers = _users.getString("primary_nick");
                    String _created_atUsers = _jObjectSub.getString("created_at");
                    String _updated_atUsers = _jObjectSub.getString("updated_at");


                } catch (JSONException e1) {
                    // TODO Auto-generated catch block
                    e1.printStackTrace();
                }