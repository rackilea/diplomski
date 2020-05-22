public static void main(String[] args)  {
  try {
    Vehicle v = new Vehicle("Opel",10,"HTG-454");
    // ...as much of the other code as appropriate (usually most or all of it)...
  }
  catch (InvalidAgeException ex) {
    // ...do something about it and/or report it...
  }
}