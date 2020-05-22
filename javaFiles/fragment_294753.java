myGroupLayer.setHitTester(new Layer.HitTester() {
  public Layer hitTest(Layer l, Point p) {
    Layer hitLayer = myGroupLayer.hitTestDefault(p);
    return (hitLayer != null) ? myGroupLayer : null;
  }
});