BeanItemContainer<State> container = new BeanItemContainer<State>(State.class);

final BeanFieldGroup<State> binder = new BeanFieldGroup<State>(State.class);
binder.setFieldFactory(new DefaultFieldGroupFieldFactory() {

    @SuppressWarnings("unchecked")
    @Override
    public <T extends Field> T createField(Class<?> type, Class<T> fieldType) {

        if (type.isAssignableFrom(Governor.class) && fieldType.isAssignableFrom(ComboBox.class)) {
            return (T) new ComboBox(); // we create a ComboBox for the Governor property
        }

        return super.createField(type, fieldType);
    }

});

final State bean = new State();

Field<?> field = null;
binder.setItemDataSource(bean);

binder.buildAndBind("State", "state");
field = binder.buildAndBind("Governor", "governor", ComboBox.class);

ComboBox cmbx = (ComboBox) field;

// We define a container data source for your Governors.
// I've taken the BeanItemContainer
cmbx.setContainerDataSource(new BeanItemContainer<Governor>(Governor.class));

// If you want to use a JPAContainer you need to translate entities to identifiers and visa versa
// cmbx.setContainerDataSource(dsGovernor);
// cmbx.setConverter(new SingleSelectConverter<Governor>(cmbx));
cmbx.setItemCaptionPropertyId("governor");

// we create two dummy Governors
Governor governorA = new Governor();
governorA.setGovernor("A");
Governor governorB = new Governor();
governorB.setGovernor("B");

// ... and add them to the container
cmbx.getContainerDataSource().addItem(governorA);
cmbx.getContainerDataSource().addItem(governorB);

// when the binder is committed the value of the ComboBox ( getValue() )is mapped to our state bean.