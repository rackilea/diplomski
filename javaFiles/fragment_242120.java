@Override
protected void init(VaadinRequest request) {

    Container cont = new IndexedContainer(); // create a container
    cont.addContainerProperty("caption", String.class, "");
    cont.getContainerProperty(cont.addItem(), "caption").setValue("first");
    cont.getContainerProperty(cont.addItem(), "caption").setValue("second");
    cont.getContainerProperty(cont.addItem(), "caption").setValue("third");

    FlexibleOptionGroup fog = new FlexibleOptionGroup(cont);
    fog.setItemCaptionPropertyId("caption");
    fog.setMultiSelect(true); // force using CheckBoxes

    VerticalLayout fogLayout = new VerticalLayout();
    Iterator<FlexibleOptionGroupItemComponent> iter;
    iter = fog.getItemComponentIterator();
    while(iter.hasNext()) {
        // OptionGroupItem part (CheckBox or RadioButton)
        FlexibleOptionGroupItemComponent fogItemComponent = iter.next();
        // CustomComponent part
        Label caption = new Label(fogItemComponent.getCaption());
        caption.setWidth(50, Unit.PIXELS);
        Slider slider = new Slider(1, 100);
        fogLayout.addComponent(
            new HorizontalLayout(fogItemComponent, caption, slider)
        );
    }
    setContent(fogLayout);
}