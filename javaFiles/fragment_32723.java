Human {
    private Head headObject;
    private Torso torsoObject; 
    private Leg rightLegObject;

    public Human (float variable1, float variable2, float variable3) {
      headObject = new Head(variable1);
      torsoObject = new Torso(variable2);
      rightLegObject = new Leg(variable3);
   }
}