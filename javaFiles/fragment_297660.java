public boolean decrementPower(int powerReduction)
 {
  if (powerReduction < 0)
     return false;  //or deal with possibility of going above maxPowerLevel
  if (powerReduction > this.getPowerLevel()){
    this.powerLevel = 0;  //or fail without performing change, whichever is right
    return false;
  } 
  this.powerLevel -= powerReduction;
  return true;
 }