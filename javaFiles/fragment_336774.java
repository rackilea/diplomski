private Alignment alignX = Alignment.CENTER;
private Alignment alignY = Alignment.CENTER;

public CustomTransformModel(Alignment alignX, Alignment alignY) {
    super();
    this.alignX = alignX;
    this.alignY = alignY;
}

@Override
public AffineTransform getTransform(JXLayer<? extends JComponent> layer) {
    JComponent view = (JComponent)layer.getView();
    /*
    * Set the current actual program values in addition to the user
    * options.
    */
    this.setValue(Type.LayerWidth, layer == null ? 0 : layer.getWidth());
    this.setValue(Type.LayerHeight, layer == null ? 0 : layer.getHeight());
    this.setValue(Type.ViewWidth, view == null ? 0 : view.getWidth());
    this.setValue(Type.ViewHeight, view == null ? 0 : view.getHeight());
    /*
    * If any change to previous values, recompute the transform.
    */
    if (!Arrays.equals(this.prevValues, this.values)) {
        System.arraycopy(this.values, 0, this.prevValues, 0, this.values.length);
        this.transform.setToIdentity();
        if (view != null) {
            double scaleX;
            double scaleY;
            double centerX;
            if(this.alignX == Alignment.LEFT) {
                centerX = 0.0;
            } else if (this.alignX == Alignment.RIGHT){
                centerX = layer == null ? 0.0 : (double)layer.getWidth();
            } else {
                centerX = layer == null ? 0.0 : (double)layer.getWidth() / 2.0;
            }
            double centerY;
            if(this.alignY == Alignment.TOP) {
                centerY = 0.0;
            } else if(this.alignY == Alignment.BOTTOM){
                centerY = layer == null ? 0.0 : (double)layer.getHeight();
            } else {
                centerY = layer == null ? 0.0 : (double)layer.getHeight() / 2.0;
            }
            AffineTransform nonScaledTransform = this.transformNoScale(centerX, centerY);
            if (((Boolean)this.getValue(Type.ScaleToPreferredSize)).booleanValue()) {
                scaleY = scaleX = ((Double)this.getValue(Type.PreferredScale)).doubleValue();
            } else {
                Area area = new Area(new Rectangle2D.Double(0.0, 0.0, view.getWidth(), view.getHeight()));
                area.transform(nonScaledTransform);
                Rectangle2D bounds = area.getBounds2D();
                scaleX = layer == null ? 0.0 : (double)layer.getWidth() / bounds.getWidth();
                scaleY = layer == null ? 0.0 : (double)layer.getHeight() / bounds.getHeight();
                if (((Boolean)this.getValue(Type.PreserveAspectRatio)).booleanValue()) {
                    scaleY = scaleX = Math.min(scaleX, scaleY);
                }
            }
            this.transform.translate(centerX, centerY);
            this.transform.scale((Boolean)this.getValue(Type.Mirror) != false ? - scaleX : scaleX, scaleY);
            this.transform.translate(- centerX, - centerY);
            this.transform.concatenate(nonScaledTransform);
        }
    }
    return this.transform;
}