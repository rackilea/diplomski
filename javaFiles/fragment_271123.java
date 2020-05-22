List<AbstractDecoration> getDecorations() {
    List<AbstractDecoration> decorations;
    if (message instanceof AbstractDecoration) {
        decorations = ((AbstractDecoration) message).getDecorations();
    }
    else {
        decorations = new ArrayList<AbstractDecoration>();
    }

    decorations.add(this);
    return decorations;
}