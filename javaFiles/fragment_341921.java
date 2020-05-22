public class Foo extends RealmObject {
  private List<Object> objects;  // not legal
  private RealmList<Object> objects;  // not legal 
  private RealmList<RealmObject> objects; // not legal
}

public class Foo extends RealmObject {
  private RealmList<Foo> objects; // legal
}

List<Foo> reference = foo.getObjects(); // Legal