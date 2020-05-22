/**
 * Returns the graphic to draw on the inside of the disclosure node. Null
 * is acceptable when no graphic should be shown. Commonly this is the
 * graphic associated with a TreeItem (i.e. treeItem.getGraphic()), rather
 * than a graphic associated with a cell.
 */
protected abstract ObjectProperty<Node> graphicProperty();