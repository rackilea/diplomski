public class CheckboxEnumBinding extends VerticalLayout {

    public CheckboxEnumBinding() {
        // form components
        TextField nameTextField = new TextField("Name");
        CheckBoxGroup<Role> roleCheckBoxGroup = new CheckBoxGroup<>("Roles", DataProvider.ofItems(Role.values()));

        // binder setup
        Binder<User> userBinder = new Binder<>();

        // name binding
        userBinder.forField(nameTextField)
                .asRequired("Please provide a user name")
                .bind(User::getName, User::setName);

        // role binding
        userBinder.forField(roleCheckBoxGroup)
                .asRequired("Please select at least one role")
                .bind(User::getRoles, User::setRoles);

        // bind to bean
        userBinder.setBean(new User("Morfic", EnumSet.of(Role.ADMIN, Role.GUEST)));

        // simulate a save action
        Button saveButton = new Button("Save", event -> Notification.show("Saved new user info: " + userBinder.getBean()));

        // add fields to the UI
        addComponents(nameTextField, roleCheckBoxGroup, saveButton);
    }
}