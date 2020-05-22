JSONObject profile = new JSONObject();
profile.put("image", anImage); //pseudo code
profile.put("name", aProfileName); //pseudo code
//...and so on

JSONObject friends = new JSONObject();
friends.put("name", aName);
//...and so on

JSONObject outer = new JSONObject();
outer.put("profile", profile);
outer.put("friends", friends);

JSONObject outers = new JSONObject();
outers.put("outer", outer);