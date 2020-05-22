public class Container {
    private int id;
    private Map<Key,String> values = new HashMap<Key,String>();

    public String getValue(String category, String property) {
        return values.get(new Key(category, property));
    }

    public void setValue(String category, String property, String value) {
        values.put(new Key(category, property), value);
    }

    public static class Key {
        private String category;
        private String property;

        public Key(String cat, String prop) {
            category = cat;
            property = prop;
        }

        public String getCategory() {
            return category;
        }

        public String getProperty() {
            return property;
        }

        @Override
        public boolean equals(Object obj) {
            if (!(obj instanceof Key)) {
                return false;
            }
            Key k = (Key)obj;
            return category.equals(k.category) && property.equals(k.property);
        }

        @Override
        public int hashCode() {
            return 37*category.hashCode() + property.hashCode();
        }
    }
}