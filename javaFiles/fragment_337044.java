/* Have a look over java.awt.geom.GeneralPath*/
// Draw the roof
GeneralPath shape=new GeneralPath();
shape.moveTo(300, 400)
shape.lineTo(800, 400);
shape.lineTo(550, 200);
shape.closePath(); // easier than shape.lineTo(300, 400);
g2.setColor(Color.RED);
g2.fill(shape);

// let's get a tinge of pink for the outline;
Stroke origStroke=g2.getStroke(); // just to restore it afterwards
g2.setColor(Color.PINK);
g2.setStroke(new BasicStroke(0.5f)); // WHOA, is that something new?
g2.draw(shape); // reusing it, why bother creating other lines?

// as we don't want the next drawing to go with a thin line,
// restore the old stroke
g2.setStroke(origStroke);