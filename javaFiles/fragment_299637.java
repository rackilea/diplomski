g.drawImage(turtle, 100, 100, this);
try {
    Thread.sleep(5000);
} catch(InterruptedException e) {}

g.clearRect(100, 100, turtle.getWidth(null), turtle.getHeight(null));
g.drawImage(turtle, 200, 200, this);