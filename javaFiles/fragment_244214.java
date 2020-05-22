public class PrimaTruck{
// instance variables - replace the example below with your own
private int topSpeed;
private OUColour colour;
public boolean engineStatus;

/**
* Constructor for objects of class PrimaTruck
* Initialise instance variables 
*/
public PrimaTruck(int topSpeed, OUColour colour, Engine engine){

 this.topSpeed = topSpeed;
 this.colour = colour;
 this.engineStatus = engine.getEngineStatus();
}