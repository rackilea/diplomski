@JsonCreator
public Foo(List<String> theList) {
    this.theList = theList;
}
...

String jsonString = "[\"a\", \"b\", \"c\"]";
Foo foo = new ObjectMapper().readValue(jsonString, Foo.class);
System.out.println(foo.getTheList());