ComboBox<BeanModel> modeCombo = new ComboBox<BeanModel>();
ListStore<BeanModel> store = new ListStore<BeanModel>();

// this next line might need ModelMarker.class instead, its been a while
BeanModelFactory modeFactory = BeanModelLookup.get().getFactory(Mode.class);


// either add items one at a time
Mode mode = Mode.EDIT;
store.add(modeFactory.createModel(mode));

// or add a collection
store.add(modeFactory.createModel(Arrays.asList(Mode.values()));