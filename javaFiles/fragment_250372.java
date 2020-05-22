public class Main extends Application {
    @Override
    public void start(Stage stage) {        
        Scene scene = new Scene(new Group());
        stage.setWidth(300);
        stage.setHeight(500);

        final TreeView<MailTreeItem> tree = new TreeView<>();
        final List<Category> categoryList = FXCollections.observableArrayList();

        tree.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<TreeItem<MailTreeItem>>() {

            @Override
            public void changed(
                    ObservableValue<? extends TreeItem<MailTreeItem>> observable,
                    TreeItem<MailTreeItem> oldValue,
                    TreeItem<MailTreeItem> newValue) {

                newValue.getValue();

            }
        });

        final List<Contact> categoryContact1List = FXCollections.observableArrayList();
        categoryContact1List.add(new Contact("Hans"));
        categoryContact1List.add(new Contact("Dieter"));

        final List<Contact> categoryContact2List = FXCollections.observableArrayList();
        categoryContact2List.add(new Contact("Peter"));

        categoryList.add(new Category("Freunde", categoryContact1List));
        categoryList.add(new Category("Feinde", categoryContact2List));

        final TreeItem<MailTreeItem> root = new TreeItem<MailTreeItem>(new RootTreeItem());
        root.setExpanded(true);
        tree.setRoot(root);
        for (Category category : categoryList) {
            final List<Contact> contactList = category.contactListProperty().get();
            final TreeItem<MailTreeItem> categoryTreeItem = new TreeItem<MailTreeItem>(new CategoryTreeItem(category));

            for (Contact contact : contactList) {
                categoryTreeItem.getChildren().add(new TreeItem<MailTreeItem>(new ContactTreeItem(contact)));
            }
            root.getChildren().add(categoryTreeItem);
        }

        final VBox vbox = new VBox();
        vbox.setSpacing(5);
        vbox.setPadding(new Insets(10, 0, 0, 10));
        vbox.getChildren().addAll(tree);

        ((Group) scene.getRoot()).getChildren().addAll(vbox);

        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

    public interface MailTreeItem {
        public boolean isCategory();
        public boolean isContact();
        public Category getCategory();
        public Contact getContact();
    }

    public class RootTreeItem implements MailTreeItem {
        @Override public String toString() { return "root"; }
        @Override public boolean isCategory() { return false; }
        @Override public boolean isContact() { return false; }
        @Override public Category getCategory() { return null; }
        @Override public Contact getContact() { return null; }      
    }

    public class CategoryTreeItem implements MailTreeItem {
        private ObjectProperty<Category> category = new SimpleObjectProperty<>();

        public CategoryTreeItem(Category category) {
            this.category.set(category);
        }

        public ObjectProperty<Category> categoryProperty() { return this.category; }

        @Override public String toString() { return this.category.get().categoryNameProperty().get(); }
        public boolean isCategory() { return true; }
        public boolean isContact() { return false; }
        public Category getCategory() { return this.category.get(); }
        public Contact getContact() { return null; } 
    }

    public class ContactTreeItem implements MailTreeItem {
        private final ObjectProperty<Contact> contact = new SimpleObjectProperty<>();

        public ContactTreeItem(Contact contact) {
            this.contact.set(contact);
        }

        public ObjectProperty<Contact> contactProperty() { return this.contact; }

        @Override public String toString() { return this.contact.get().contactNameProperty().get(); }
        public boolean isCategory() { return false; }
        public boolean isContact() { return true; }
        public Category getCategory() { return null; }
        public Contact getContact() { return this.contact.get(); } 
    }

    public class Category {
        private final StringProperty categoryName = new SimpleStringProperty();
        private final ListProperty<Contact> contactList = new SimpleListProperty<>(FXCollections.<Contact>observableArrayList());

        public Category(String name, List<Contact> contactList) {
            this.categoryName.set(name);
            this.contactList.setAll(contactList);
        }

        public StringProperty categoryNameProperty() { return this.categoryName; }
        public ListProperty<Contact> contactListProperty() { return this.contactList; }
    }

    public class Contact {
        private final StringProperty contactName = new SimpleStringProperty();

        public Contact(String name) {
            this.contactName.set(name);
        }

        public StringProperty contactNameProperty() { return this.contactName; }
    }
}