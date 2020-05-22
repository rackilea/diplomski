public void updateList(.....){

    CommonGateway usersobj= new CommonGateway(this);

    //Set the value..
   usersobj.SetData("Users", R.drawable.usersico,musers);
   getLinearListAdapter().add(usersobj);

}