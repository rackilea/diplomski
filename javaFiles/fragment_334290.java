SVGDocument   document = canvas.getSVGDocument();
SVGGElement   g        = (SVGGElement) document.getElementById("FrontRight_1");
SVGSVGElement svg      = g.getOwnerSVGElement();

SVGPoint pt = svg.createSVGPoint();
pt.setX(190.7826f);
pt.setY(1756.51f);

SVGMatrix groupTransformMatrix = g.getTransform().getBaseVal().consolidate().getMatrix();

pt = pt.matrixTransform(groupTransformMatrix);