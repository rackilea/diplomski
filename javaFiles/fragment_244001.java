@Override
protected void init(VaadinRequest vaadinRequest) {
    final VerticalLayout layout = new VerticalLayout();
    final ComboBox<String> main = new ComboBox<>();
    final ComboBox<String> dependent = new ComboBox<>();
    final Map<String, String[]> dependentsByMain = new HashMap<>();
    dependentsByMain.put("A", new String[]{"AA", "AB", "AC"});
    dependentsByMain.put("B", new String[]{"BA", "BB", "BC"});
    dependentsByMain.put("C", new String[]{"CA", "CB", "CC"});

    List<String> mainItems = new ArrayList<>(dependentsByMain.keySet());
    main.setItems(mainItems);
    dependent.setItems(Arrays.asList("Test1", "Test2", "Test3"));
    dependent.setValue("Test1");
    main.addValueChangeListener((HasValue.ValueChangeListener<String>) valueChangeEvent -> {
        if (valueChangeEvent.getValue() != null) {
            dependent.setItems(dependentsByMain.get(valueChangeEvent.getValue()));
            dependent.setValue(null);
        }
    });
    layout.addComponents(main, dependent);
    setContent(layout);
}