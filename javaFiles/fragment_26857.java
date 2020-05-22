List<CompoundObjectWithAStringProperty> foo = /* go get the list */
List<String> allProperties = new ArrayList<String>();

for (CompoundObjectWithAStringProperty obj : foo) {
    allProperties.add(obj.getStringProperty());
}