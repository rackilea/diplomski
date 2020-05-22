// I needed to fill the table with an IndexedContainer
final IndexedContainer container = new IndexedContainer();
// table headers
container.addContainerProperty("Metadata Key", String.class, null);
container.addContainerProperty("Metadata Value", String.class, null);

// Now fill the container with my hashmap (objectMetadatas) and at the end we will add the container to the table
int i = 0;
for (String k : objectMetadatas.keySet()) {
    Integer rowId = new Integer(i);
    container.addItem(rowId);
    container.getContainerProperty(rowId, "Metadata Key").setValue(k);
    container.getContainerProperty(rowId, "Metadata Value").setValue(objectMetadatas.get(k));
    i++;
}

// then added a ValueChangeListener to the container
container.addListener(new Property.ValueChangeListener() {
    public void valueChange(ValueChangeEvent event) {
         Property p = event.getProperty(); // not necessary
             System.out.println(p);        // not necessary
    }
});

// add the the button to update the table and get the changed values into your hashmap
buttonUpdate.addListener(new Button.ClickListener() {
    public void buttonClick(ClickEvent event) {
        Map<String, String> map = new HashMap<String,String>();
        Collection i = tableMetadata.getContainerDataSource().getItemIds();
        for (int x = 0; x < i.size(); x++) {
            // Items in Vaadin represent rows, since I have two columns
            // i have only two values in my row as following: "row1 row2"
            // if you have four columns on your table 
            // your item will look like this: "row1 row2 row3 row4"
            Item it=myTable.getContainerDataSource().getItem(x);
            // thats why I am splitting it
            String[] row= it.toString().split(" ");
            map.put(row[0], row[1]);
        }
        // Now all changed values are in your map! 
        // Do sth with that map
    }
});

// Finally do not forget to add that container to your table
tableMetadata.setContainerDataSource(container);