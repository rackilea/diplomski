import com.vaadin.contextmenu.GridContextMenu;
import com.vaadin.icons.VaadinIcons;
import com.vaadin.ui.Grid;
import com.vaadin.ui.Notification;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;

public class MyUi extends UI {
    @Override
    protected void init(VaadinRequest request) {
        // basic grid setup
        Grid<Person> grid = new Grid<>(Person.class);
        grid.getColumns().forEach(column -> column.setHidable(true).setSortable(true));
        grid.setItems(
                new Person("Darth", "Vader"),
                new Person("Luke", "Skywalkaer"),
                new Person("Java", "De-Hut")
        );

        // grid context menu setup
        Random random = new Random();
        GridContextMenu<Person> contextMenu = new GridContextMenu<>(grid);
        // handle header right-click
        contextMenu.addGridHeaderContextMenuListener(event -> {
            contextMenu.removeItems();
            contextMenu.addItem("Hide", VaadinIcons.EYE_SLASH, selectedMenuItem -> {
                event.getColumn().setHidden(true);
            });
            contextMenu.addItem("Sort", VaadinIcons.LIST_OL, selectedMenuItem -> {
                grid.sort(event.getColumn().getId(), SortDirection.values()[random.nextInt(2)]);
            });
        });
        // handle item right-click
        contextMenu.addGridBodyContextMenuListener(event -> {
            contextMenu.removeItems();
            if (event.getItem() != null) {
                grid.select((Person) event.getItem());
                contextMenu.addItem("Info", VaadinIcons.INFO, selectedMenuItem -> {
                    Notification.show("Right-clicked item " + event.getItem());
                });
            }
        });

        // set UI content
        VerticalLayout content = new VerticalLayout();
        content.setSizeFull();
        content.addComponents(grid);
        setContent(content);
    }

    // basic bean
    public static class Person {
        private String firstName;
        private String lastName;

        public Person(String firstName, String lastName) {
            this.firstName = firstName;
            this.lastName = lastName;
        }

        public String getFirstName() {
            return firstName;
        }

        public void setFirstName(String firstName) {
            this.firstName = firstName;
        }

        public String getLastName() {
            return lastName;
        }

        public void setLastName(String lastName) {
            this.lastName = lastName;
        }

        @Override
        public String toString() {
            return "Person{" +
                    "firstName='" + firstName + '\'' +
                    ", lastName='" + lastName + '\'' +
                    '}';
        }
    }
}