for (Bird bird : birds) 
    bird.fly();

// bird is not in scope anymore
g.setColor(bird.getColor());
Point pos = bird.getPosition();
g.fillOval((int)pos.getX()*PIXELS, (int)pos.getY()*PIXELS,
PIXELS, PIXELS);
panel.sleep(500);