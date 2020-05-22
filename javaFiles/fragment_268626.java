// add all values of this object's attributes with 2nd map
public void addAttributes(Map<Attribute, Integer> attributes2) {
    for (Attribute attribute : Attribute.values()) {
        int value = attributes.get(attribute) + attributes2.get(attribute);
        attributes.put(attribute, value);
    }
}