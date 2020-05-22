public interface Car {

  RegistrationNumber getRegistration();

  int getFuelCapacity();

  // int getFuelLevel(); this can not be implemented
  // all methods in an interface are PUBLIC
  // so you have to lower the access level by removing it from the interface

  // HERE goes the rest of the method signatures

}