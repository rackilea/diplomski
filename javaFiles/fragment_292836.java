public void addNewUser(String email, String username, String bio, String website, String interests, String address, String profile_photo){

    User user = new User(userID,1 , email, address, StringManipulation.condenseUsername(username));

    myRef.child(mContext.getString(R.string.dbname_users))
            .child(userID)
            .setValue(user);

    UserAccountSettings settings = new UserAccountSettings(
            interests, username, 0, 0, 0, "", username, website, bio
    );

    myRef.child(mContext.getString(R.string.dbname_user_account_settings))
            .child(userID)
            .setValue(settings);
}