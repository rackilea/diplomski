public final class Car { 

  final String registration; 
  final String owner; 

  public Car(String registration, String owner) { 
    this.registration = registration; 
    this.owner= owner; 
  } 

  public String getRegistration() { 
    return registration; 
  } 

  public String getOwner() { 
    return owner; 
  } 
}