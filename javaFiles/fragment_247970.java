Component createTopRow() {
    Label spacer = new Label();
    spacer.setWidthUndefined();
    HorizontalLayout topRow = new HorizontalLayout( spacer, name, concept, apparentAge );
    topRow.setExpandRatio(spacer, 1);
    topRow.setSpacing( true );
    topRow.setWidth( 100, Unit.PERCENTAGE );
    return topRow;
}