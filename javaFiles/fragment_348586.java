g2.draw(barra);
AffineTransform orig = g2.getTransform();
g2.rotate(-Math.PI/2);
g2.setColor(Color.BLACK);
g2.drawString(datos[i].titulo,(float)alto,(float)paso);
g2.setTransform(orig);