String s;
int i = 0;

while (accountData.next()){
        s = userData.getString("User_ID");
        //you have s now you can do things with it
        userID.addElement(s); 
        i++;
    }