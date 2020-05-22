public class User extends RealmObject {
  public static final String NAME = "name";
  public static final String AGE = "age";

  // Fields, constructors, getters, setters,
}

realm.where(Person.class).equalTo(Person.NAME, "John").findAll();