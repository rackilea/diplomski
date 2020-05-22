private Alignment alignX; // horizontal alignment
private Alignment alignY; // verticalalignment

public TransformUI(TransformModel model, Alignment alignX, Alignment alignY) {
    super();
    this.setModel(model);
    this.alignX = alignX;
    this.alignY = alignY;
}

public Alignment getAlignX() {
    return alignX;
}

public Alignment getAlignY() {
    return alignY;
}