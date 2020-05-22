List<Entity> entities = new ArrayList<Entity>();

public void paintComponent(Graphics g) {
  for (Entity e : entities)
    e.draw(g);
}

public void keyPressed() {
  entities.add(new LaserEntity(...));
}