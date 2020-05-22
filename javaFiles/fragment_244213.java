public class Engine{

// instance variables
public boolean engineStart;
public boolean engineStop;
public boolean engineStatus;

/**
* Constructor for objects of class Engine
*@param1 - true if engine is started
*@param2 - true if engine is stopped
*@param3 - true if engine is on, else false
*/
public Engine(boolean engineStart, boolean engineStop, boolean engineStatus){

// initialise instance variables
this.engineStart = engineStart;
this.engineStop = engineStop;
this.engineStatus = engineStatus;

}

public boolean getEngineStart(){
     return engineStart; 
}

public void setEngineStart(){
 this.engineStop = false;
 this.engineStart = true;
 setEngineStatus(true);
}

public boolean getEngineStop(){
 return engineStop; 
}

public void setEngineStop(){
 this.engineStart = false;
 this.engineStop = true;
 setEngineStatus(false);
}

public void setEngineStatus(boolean engineStatus){

 this.engineStatus = engineStatus;

} 

public String getEngineStatus(){
 return engineStatus;
}
}