public void centerViewsOnVertex(SynsetVertex v) {
  //the following location have sense in the space of the layout
  Point2D v_location = layout.transform(v);
  Point2D vv1_center_location = vv1.getRenderContext()
                .getMultiLayerTransformer()
                .inverseTransform(Layer.LAYOUT, vv1.getCenter());

  double scale = vv1.getRenderContext().getMultiLayerTransformer().getTransformer(Layer.VIEW).getScale();

  vv1.getRenderContext().getMultiLayerTransformer().getTransformer(Layer.LAYOUT).translate(
                        -(v_location.getX() - vv1_center_location.getX()) * 1
                                / scale,
                        -(v_location.getY() - vv1_center_location.getY()) * 1
                                / scale);

  refreshViews();
}