public void render(Graphics g) {
    for (int i = 0; i < handlerList.size(); i++) {
        //handlerList is a LinkedList
        Graphics2D g2d = (Graphics2D)g.create();
        handlerList.get(i).render(g2d);
        g2d.dispose();
    }
}