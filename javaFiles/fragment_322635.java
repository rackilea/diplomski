public void deselectAll() {
    Iterator<GraphicalObject> iterator = selectedObjects.iterator();
    while(iterator.hasNext()) {
        GraphicalObject g = iterator.next();
        iterator.remove();    // removes g from selectedObjects
        g.setSelected(false); // deselects g
    }
}