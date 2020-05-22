public class MyApplication extends Application {

@Override
public void init() {
    Window mainWindow = new Window("MyApplication");

    // Create the original container
    IndexedContainer originalContainer = new IndexedContainer();
    originalContainer.addContainerProperty("id", Integer.class, null);
    originalContainer.addContainerProperty("imgtext", String.class, null);

    // Add some dummy data
    Item item0 = originalContainer.getItem(originalContainer.addItem());
    item0.getItemProperty("id").setValue(1);
    item0.getItemProperty("imgtext").setValue("First");
    Item item1 = originalContainer.getItem(originalContainer.addItem());
    item1.getItemProperty("id").setValue(2);
    item1.getItemProperty("imgtext").setValue("Second");

    // Create a modified container
    IndexedContainer modifiedContainer = new IndexedContainer();
    for(Object propId : originalContainer.getContainerPropertyIds()) {
        if(propId.equals("imgtext")) {
            // Change the imgtext property type from String to Label
            modifiedContainer.addContainerProperty(propId, Label.class, null);
        } else {
            modifiedContainer.addContainerProperty(propId, originalContainer.getType(propId), null);
        }
    }

    // Add the data
    for(Object itemId : originalContainer.getItemIds()) {
        Item item = originalContainer.getItem(itemId);
        Item newItem = modifiedContainer.addItem(itemId);
        for(Object propId : originalContainer.getContainerPropertyIds()) {
            if(propId.equals("imgtext")) {
                String text = item.getItemProperty(propId).getValue().toString();
                Label label = new Label();
                label.setContentMode(Label.CONTENT_XHTML);
                label.setValue("<img src=\"" + getImgUrl(text) + "\" /> " + text);
                newItem.getItemProperty(propId).setValue(label);
            } else {
                newItem.getItemProperty(propId).setValue(item.getItemProperty(propId).getValue());
            }
        }
    }

    // Create the table and set the data source
    Table table = new Table();
    table.setWidth(700, Table.UNITS_PIXELS);
    table.setContainerDataSource(modifiedContainer);

    mainWindow.addComponent(table);
    setMainWindow(mainWindow);
}

private String getImgUrl(String text) {
    return "http://myurl.com/image.png";
}
}