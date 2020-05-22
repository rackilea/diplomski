@Override
public void layoutContainer(Container parent) {
    JXLayer<?> layer = (JXLayer<?>) parent;
    LayerUI<?> layerUI = layer.getUI();
    if (layerUI instanceof CustomTransformUI) {
        JComponent view = (JComponent) layer.getView();
        JComponent glassPane = layer.getGlassPane();
        if (view != null) {
        Rectangle innerArea = new Rectangle();
        SwingUtilities.calculateInnerArea(layer, innerArea);
        view.setSize(view.getPreferredSize());
        Rectangle viewRect = new Rectangle(0, 0, view.getWidth(), view
            .getHeight());
        int x;
        int y;
        Alignment alignX = ((CustomTransformUI) layerUI).getAlignX();
        Alignment alignY = ((CustomTransformUI) layerUI).getAlignY();
        if(alignX == Alignment.LEFT) {
            x = (int) (innerArea.getX() - viewRect.getX());
        } else if(alignX == Alignment.RIGHT) {
            x = (int) (innerArea.getX()+innerArea.getWidth()-viewRect.getWidth()-viewRect.getX());
        } else {
            x = (int) Math.round(innerArea.getCenterX()
                    - viewRect.getCenterX());
        }
        if(alignY == Alignment.TOP) {
            y = (int) (innerArea.getY() - viewRect.getY());
        } else if(alignY == Alignment.BOTTOM) {
            y = (int) (innerArea.getY()+innerArea.getHeight()-viewRect.getHeight()-viewRect.getY());
        } else {
            y = (int) Math.round(innerArea.getCenterY()
                    - viewRect.getCenterY());
        }
        viewRect.translate(x, y);
        view.setBounds(viewRect);

        }
        if (glassPane != null) {
        glassPane.setLocation(0, 0);
        glassPane.setSize(layer.getWidth(), layer.getHeight());
        }
        return;
    }
    super.layoutContainer(parent);
}