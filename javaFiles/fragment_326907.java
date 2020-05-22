protected List<GreyHound> greyHounds; // List<GreyHound> is fine

/** This method returns a lovely List of GreyHounds */
public List<GreyHound> getGreyHounds() { 
  return this.greyHounds;
}

/** Here is the problem.  A List<GreyHound> is not a List<Dog> */
public List<Dog> getDogs() {
  return getGreyHounds(); //compiler error
}