StringBuilder builder = new StringBuilder("Start");
if (someCondition) {
    builder.append("Foo");
}
if (someOtherCondition) {
    builder.append("Bar");
}
builder.append("End");
String result = builder.toString();