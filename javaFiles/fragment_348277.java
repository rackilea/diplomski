public class Aircraft {
    private LandingGear myLandingGear;


    public Aircraft() {
        myLandingGear = new LandingGear();
   }

   public LandingGear getLandingGear() {
       return this.myLandingGear;
   }

}