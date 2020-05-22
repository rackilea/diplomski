@Test public void componentChecksSpeed() {
  YourComponent yourComponent = Mockito.spy(new YourComponent());

  // Use doReturn, because the when syntax would actually invoke readSpeed.
  doReturn(65).when(yourComponent).readSpeed(any(Point.class), any(Point.class));

  yourComponent.run();
}