@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "testTO", propOrder = {
    "elements"
})
public abstract class TestTO {

    @XmlElement(required = true, type = TestTO.Elements.class)
    protected Map<String, Object> elements;

    public Map<String, Object> getElements() {
        return elements;
    }

    public void setElements(Map<String, Object> value) {
        this.elements = value;
    }

    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "entry"
    })
    public static class Elements {

        protected List<TestTO.Elements.Entry> entry;

        public List<TestTO.Elements.Entry> getEntry() {
            if (entry == null) {
                entry = new ArrayList<TestTO.Elements.Entry>();
            }
            return this.entry;
        }

        @XmlAccessorType(XmlAccessType.FIELD)
        @XmlType(name = "", propOrder = {
            "key",
            "value"
        })
        public static class Entry {

            protected java.lang.String key;
            protected java.lang.Object value;

            public java.lang.String getKey() {
                return key;
            }

            public void setKey(java.lang.String value) {
                this.key = value;
            }

            public java.lang.Object getValue() {
                return value;
            }

            public void setValue(java.lang.Object value) {
                this.value = value;
            }
        }
    }
}