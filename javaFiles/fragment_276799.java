// define a type values as an enum:
enum TypeValue {
  Noun, Verb
}

// define an attribute class parametrized by an enum:
public class Attribute<E extends Enum<E>> {

    // define your attribute types as static fields inside this class
    public static Attribute<TypeValue> Type = new Attribute<TypeValue>();
}

// and now define your method like this:
<E extends Enum<E>, Feature extends Attribute<E>> void put(Feature feature, E value) {
}

// you will then have a compilation error when trying to invoke the method with improper associated parameters.

// eg if we define
enum OtherValue { X }

features.put(Attribute.Type, TypeValue.Noun); // ok
features.put(Attribute.Type, OtherValue.X); // Fails