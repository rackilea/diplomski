// add all values of this object's attributes with 2nd map
public void addAttributes(Map<Attribute, Integer> attributes2) {
    for (Attribute attribute : Attribute.values()) {
        int value = attributes.get(attribute) != null ? attributes.get(attribute) : 0;
        int value +=  attributes2.get(attribute) != null ? attributes2.get(attribute) : 0;
        attributes.put(attribute, value);
    }
}