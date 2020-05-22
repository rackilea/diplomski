public void saveUserDetails(String imageUri){

           UserProfile userProfile = new UserProfile(user_Name, user_Age, user_Email, user_Phone, imageUri);
                myRef.setValue(userProfile);
                Toast.makeText(getApplicationContext(), "User Data Sent.", Toast.LENGTH_SHORT).show();
     }