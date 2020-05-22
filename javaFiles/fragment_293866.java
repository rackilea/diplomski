class APIClass{
  interface UserInfo{
    public Address getAddress();
    public Team getTeam();
  }

  UserInfo getUserInfo(String name) {
    // query the DB
    return new UserInfo(){
         public Address getAddress(){ return address; }
         public Team getTeam(){ return team; }
    };
  }
}