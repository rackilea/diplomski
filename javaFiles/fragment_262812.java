/* this is user defined method  to fetch current user firstnam and last name */

public void getUser(){

    try{
        JSONObject json = Util.parseJson( mFacebook.request("me"));
        String facebookID = json.getString("id");
        String firstName = json.getString("first_name");
        String lastName = json.getString("last_name");
        mFirstName=firstName;
        mLastName=lastName;
        mText.setText("You are logged in : "+mFirstName+"."+mLastName);
        System.out.println("Firstname>>"+firstName+" LastName>>"+lastName);
    }catch (Exception e) {
        // TODO: handle exception
    }catch(FacebookError fbe){

    }
}