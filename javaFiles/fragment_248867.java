public class Planet {
private String typeName; // key in json should match variable name for proper deserialization or you need to use some jackson annotation to map your json key to your variable name.
private List<Element> elements;

public Planet() {}

public Planet(String typeName, List<Element> elements)
{
this.typeName = typeName;
this.elements = elements;
}
//setters and getters. Remember to change your setters and getter from name to typeName.

}