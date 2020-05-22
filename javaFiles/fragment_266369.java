...
public void addCell(String id, CellType type) {

    switch (type) {

    case RECTANGLE:
        RectangleCell rectangleCell = new RectangleCell(id);
        addCell(rectangleCell);
        break;

    case TRIANGLE:
        TriangleCell circleCell = new TriangleCell(id);
        addCell(circleCell);
        break;

    case LABEL:
        LabelCell labelCell = new LabelCell(id);
        addCell(labelCell);
        break;

    case IMAGE:
        ImageCell imageCell = new ImageCell(id);
        addCell(imageCell);
        break;

    case BUTTON:
        ButtonCell buttonCell = new ButtonCell(id);
        addCell(buttonCell);
        break;

    case TITLEDPANE:
        TitledPaneCell titledPaneCell = new TitledPaneCell(id);
        addCell(titledPaneCell);
        break;

    default:
        throw new UnsupportedOperationException("Unsupported type: " + type);
    }
}
...