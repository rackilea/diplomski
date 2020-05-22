int nbDigitsYouWant=8;
Random r=new Random();
for(int i=0;i<nbDigitsYouWant;i++){
  //display hexa representation
  System.out.print(String.format("%x",r.nextInt(16)));
}