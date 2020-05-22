class ShakyFactoryBuilding extends Building implements Factory{

  ShakyFactoryBuilding(){
   super(); 
  }

  @Override
  public void printBuildQuality(){
   println("The build quality is shaky");
  }

  @Override
  public void printFactoryOutput(){
   println("This factory makes slightly different stuff"); 
  }
}