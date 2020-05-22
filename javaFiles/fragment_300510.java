private void populateUserInfoList() {
    userInfoList = new ArrayList<UserInfo>();
    firebase = new Firebase("https://....firebaseio.com");
    firebase.child("users").addValueEventListener(new ValueEventListener() {
        @Override
        public void onDataChange(DataSnapshot snapshot) {
            HashMap<String, Object> users = (HashMap<String, Object>) snapshot.getValue();
            for (Object user : users.values()) {
                HashMap<String, Object> userMap = (HashMap<String, Object>) user;
                String userNumber = (String) userMap.remove("number");
                if (!userInfoList.contains(userNumber)) {
                    String name = (String) userMap.remove("username");
                    String pic = (String) userMap.remove("profile_picture");
                    UserInfo info = new UserInfo(userNumber, name, pic);
                    userInfoList.add(info);
                }
            }
            // thread executing here can get info from database and make subsequent call
            Collections.addAll(userInfoList); 
            populateFriendsListView();
        }
        @Override
        public void onCancelled(FirebaseError firebaseError) {
            String message = "Server error. Refresh page";
            Toast.makeText(context, message, Toast.LENGTH_SHORT).show();
        }
    });
}