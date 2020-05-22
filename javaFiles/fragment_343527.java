int x = 200; int y = 200;
Ellipse2D.Double first = new Ellipse2D.Double(x,y,75,75);
Ellipse2D.Double second = new Ellipse2D.Double(x+25,y,75,75);
Area circles = new Area(first);
circles.add(new Area(second));

graphics2D.draw(circles);