@MarshalMixin // marshal fields but not a top-level object
interface Uuided {
  @MarshalAsString // ignore properties; just call toString()
  @MarshalId // treat as identifier for @MarshalUsingIds or cyclic ref
  UUID getId();
}
@MarshalMixin
interface Named {
  @MarshalId
  String getName();
}
@MarshalObject // top-level marshaled object providing class name
interface Component extends Uuided, Named {
  @MarshalAsKeyedObjectMap(key = "name") // see description below
  Map<String, ComponentAttribute> getAttributes();
}
@MarshalObject
interface Attribute extends Named {
  Type getType();
  @MarshalDynamic // use run-time (not declared) type
  Object getValue();
}
interface ComponentAttribute extends Attribute {
  @MarshalUsingIds
  Component getDeclaringComponent();
}