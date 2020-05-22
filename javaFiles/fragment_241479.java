else if (resultCode == Activity.RESULT_OK) {

   List<String> tmpList = intent.getExtra("list");
   List<GraphUser> list = new ArrayList<GraphUser>();
   for (String tmpString : tmpList) {
       GraphUser user = (GraphUser) GraphObject.Factory.create(new JSONObject(tmpString), ,GraphUser.class);
       list.add(user);
   }
}