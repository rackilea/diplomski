public void setEngine(String engine)// setEngine by using switch loop to
                                   // invoke the classes that extend from
                                   // engine
{
  switch (engine) {
  case "Hybrid":
     setEngine(new Hybrid());
     break;
  case "Gasoline":
     setEngine(new Gasoline());
     break;
  default:
     System.out.println("Invalid engine entry: " + engine);
  }// end of switch loop for engine
 }// end of setEngine switch loop