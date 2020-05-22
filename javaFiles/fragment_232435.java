switch (arg0.getActionCommand()) {
    case "Intersections":
        intersect = intersections.isSelected();
        break;
    case "Union":
        uni = union.isSelected();
        break;
    case "Clear Image":
        drawingArea.clearImage();
        break;
    case "Save Image":
        drawingArea.saveImage();
        break;
}