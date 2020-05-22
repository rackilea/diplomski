public enum Vehicle {
  CAR("CAR", "Car"){
    public BaseDAO getNewDAO(){
      return new CarDAO();
    }
  },
  PUSHBIKE("PUSHBIKE", "PuschBike"){
    public BaseDAO getNewDAO() {
      return new PushBikeDAO();
    }
  };

  Vehicle(String a, String b){/* ... */}
  //this forces every enum constant to implement a getNewDAO() method:
  abstract BaseDAO getNewDAO();
}