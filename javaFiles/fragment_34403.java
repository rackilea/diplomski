submitButton.addClickListener(event -> {
    BoundingBox box = bb.get(bb.size() - 1);
    box.setName(boxname.getValue());
    box.setBoxcategory(boxcategory.getValue());
    Canvas.redrawBox(box);
    boxname.clear();
    boxcategory.clear();
}