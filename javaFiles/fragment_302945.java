public Icon(VaadinIcon icon) {
    this(ICON_COLLECTION_NAME, icon.name().toLowerCase().replace('_', '-'));
}

public Icon(String collection, String icon) {
    // iron-icon's icon-attribute uses the format "collection:name",
    // e.g. icon="vaadin:arrow-down"
    getElement().setAttribute(ICON_ATTRIBUTE_NAME, collection + ':' + icon);
}