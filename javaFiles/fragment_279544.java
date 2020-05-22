public class DownloadFileTable extends CustomComponent {

private String currentSelectedFile = null;

public DownloadFileTable() {

    VerticalLayout layout = new VerticalLayout();
    setCompositionRoot(layout);

    IndexedContainer container = new IndexedContainer();
    container.addContainerProperty("name", String.class, "default");
    container.addItem("image1.jpg").getItemProperty("name").setValue("image1.jpg");
    container.addItem("text.csv").getItemProperty("name").setValue("text.csv");
    container.addItem("document.doc").getItemProperty("name").setValue("document.doc");

    Button downloadButton = new Button("Download selected file");
    final BrowserWindowOpener browserWindowOpener = new BrowserWindowOpener(new ExternalResource("http://google.com") {

        @Override
        public String getURL() {
            return currentSelectedFile;
        }
    });
    browserWindowOpener.setFeatures("location=0");
    browserWindowOpener.extend(downloadButton);

    Table table = new Table("Files", container);
    table.setSelectable(true);
    table.setImmediate(true);
    table.addValueChangeListener(new Property.ValueChangeListener() {
        @Override
        public void valueChange(Property.ValueChangeEvent event) {
            currentSelectedFile = (String) event.getProperty().getValue();
            browserWindowOpener.markAsDirty();
        }
    });
    layout.addComponent(table);
    layout.addComponent(downloadButton);
}