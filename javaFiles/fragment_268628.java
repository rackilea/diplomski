public class Individual {
    private Map<Attribute, Integer> attributes;

    // default constructor
    public Individual() {
        // create map and initialize all attributes to 0
        attributes = new EnumMap<>(Attribute.class);
        for (Attribute attribute : Attribute.values()) {
            attributes.put(attribute, 0);
        }
    }

    // constructor that sets attributes
    public Individual(Map<Attribute, Integer> attributes) {
        this.attributes = attributes;
    }

    public Map<Attribute, Integer> getAttributes() {
        return attributes;
    }

    public void setAttributes(Map<Attribute, Integer> attributes) {
        this.attributes = attributes;
    }

    public void setAttribute(Attribute attribute, int value) {
        attributes.put(attribute, value);
    }

    public int getAttribute(Attribute attribute) {
        return attributes.get(attribute).intValue();
    }

    // add all values of this object's attributes with 2nd map
    public void addAttributes(Map<Attribute, Integer> attributes2) {
        for (Attribute attribute : Attribute.values()) {
            int value = attributes.get(attribute) != null ? attributes.get(attribute) : 0;
            int value +=  attributes2.get(attribute) != null ? attributes2.get(attribute) : 0;
            attributes.put(attribute, value);
        }
    }

    public void addAttributes(Individual individual2) {
        addAttributes(individual2.getAttributes());
    }

     public String displayAttributes() {
        StringBuilder sb = new StringBuilder();
        // ... iterate through the attributes appending to the StringBuilder
        return sb.toString();
    }
}