public interface OrderedXml {
  ImmutableMap<String, Object> toOrderedMap();
}

public class Parent implements OrderedXml {
  @Key("First") String first;
  @Key("Second") String second;
  @Key("Child") Child third;

  @Override
  public ImmutableMap<String, Object> toOrderedMap() {
    return ImmutableMap.of(
      // the order of elements in this map will be the order they are serialised
      "First", first,
      "Second", second,
      "Child", third.toOrderedMap()
    );
  }
}

public class Child implements OrderedXml {
  @Key("@param1") String param1;
  @Key("@param2") String param2;
  @Key("text()") String value;

  @Override
  public ImmutableMap<String, Object> toOrderedMap() {
    return ImmutableMap.of(
      // the same goes for attributes, these will appear in this order
      "@param1", param1,
      "@param2", param2,
      "text()", value
    );
  }
}

public class Main {
  public static void main(String[] args) {
    // make the objects
    Parent parent = new Parent();
    parent.first = "Hello";
    parent.second = "World";
    parent.child = new Child();
    parent.child.param1 = "p1";
    parent.child.param2 = "p2";
    parent.child.value = "This is a child";
    // serialise the object to xml
    String xml = new XmlNamespaceDictionary()
        .toStringOf("Parent", parent.toOrderedXml()); // the important part
    System.out.println(xml); // should have the correct order
  }
}