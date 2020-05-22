String strUsers = object.getString("id").toString();
Log.d("users", strUsers);

usersList.setName(object.getString("name"));

if(listMultiUsers.contains(strUsers))
 {
     usersListArrayList.add(usersList);
 }