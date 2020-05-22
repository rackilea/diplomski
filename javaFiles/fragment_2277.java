AffineTransform old = g2d.getTransform();
g2d.rotate(Math.toRadians(lLegRot));
g2d.fillRect(pX + (headW - bodyW)/2, pY + headH + bodyH, legW, legH); //left leg
g2d.setTransform(old);
g2d.rotate(Math.toRadians(rLegRot));
g2d.fillRect(pX + headW - legW - (headW - bodyW)/2, pY + headH + bodyH, legW, legH); //right leg