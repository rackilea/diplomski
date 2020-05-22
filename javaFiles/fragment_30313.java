try {
  while(cursor.hasNext()) {
    myDoc = cursor.next();
    System.out.println("Cursor Test" + myDoc.toJson());
    try {
      JSONObject object = new JSONObject(myDoc.toJson());
      UserName.add((String) object.get("name"));
      UserID.add((String) object.get("id"));
      ProfilePic.add( (String) object.get("ProfilePic"));
    } catch (JSONException e) {
      e.printStackTrace();
    }
  }
} finally{cursor.close();}