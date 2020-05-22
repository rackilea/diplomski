class First {
  public Object[] array = ...;
}

class Second {
  public fillArrayAndPassItToThird(Third third) {
    First first = new First();
    // fill in the array...
    // then pass it to Third
    third.processArrayFromFirst(first);
  }
}

class Third {
  public void processArrayFromFirst(First first) {
    // process First.array
  }
}