protected void init(VaadinRequest request) {
    final HorizontalLayout layout = new HorizontalLayout();
    final Button button = new Button("Run");

    final ListSelect select = new ListSelect();

    select.setNullSelectionAllowed(false);
    final List<ItemBean> list = new LinkedList();
    //Add elements to list
    list.add(new ItemBean("Item1", 1));
    list.add(new ItemBean("Item2", 2));
    list.add(new ItemBean("Item3", 3));
    list.add(new ItemBean("Item4", 4));
    list.add(new ItemBean("Item5", 5));

    final BeanItemContainer<ItemBean> beanBeanItemContainer = new BeanItemContainer<>(ItemBean.class);
    beanBeanItemContainer.addAll(list);

    select.setContainerDataSource(beanBeanItemContainer);


    //Shuffle the list
    button.addClickListener(new Button.ClickListener() {
        @Override
        public void buttonClick(Button.ClickEvent clickEvent) {
            select.removeAllItems();

            Collections.shuffle(list);

            beanBeanItemContainer.addAll(list);


        }
    });

    layout.addComponents(button);
    layout.addComponent(select);
    layout.setMargin(true);
    layout.setSpacing(true);

    setContent(layout);
}