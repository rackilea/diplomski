public class CatTable {
    List<SimpleStringProperty> properties = new ArrayList<>();
    public void addProperty(SimpleStringProperty property) {
        properties.add(property);
    }
    public SimpleStringProperty getProperty(int index) {
        return properties.get(index);
    }
    public String getPropertyValue(int index) {
        return getProperty(index).get();
    }
    // other stuff...
}