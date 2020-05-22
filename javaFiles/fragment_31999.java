File f = new File("awesome_tiger.svg");
g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
SVGUniverse svgUniverse = new SVGUniverse();
try {
  SVGDiagram diagram = svgUniverse.getDiagram(svgUniverse.loadSVG(f.toURI().toURL()));
  try {
    AffineTransform at = new AffineTransform();
    at.setToScale(jdpPane.getWidth()/diagram.getWidth(), jdpPane.getWidth()/diagram.getWidth());
    g.transform(at);
    diagram.render(g);
  }
  catch(Exception e2) {System.out.println(e2);}}
catch (Exception ex) {System.out.println(ex);}