public class Group {
  private final MyObject card;

  public Group(MyObject card) {
      this.card = card;
  }
}


public class MyObject {
  private final Group group;

  public MyObject () {
     // initialise MyObject

     // do this only after initialising MyObject
     group = new Group(this);
  }
}

// to create both at once.
MyObject obj = new MyObject(); // will have a Group inside.