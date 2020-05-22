private Point getCoords(int x, int y, Texture t){
    boolean found = false;
    final int width = map.getTileWidth();
    final int height = map.getTileHeight();
    while(!found) {
            x = new Random().nextInt(map.getWidth() * width);
            y = new Random().nextInt(map.getHeight() * height);
            for (int i=bases.size()-1; i> -1; i--) {
                if (!bases.get(i).intersects(new Rectanble(x,y, width, height))){
                        found = true;
                } else found = false;
            }
    }

        bases.add(new Rectangle(x,y,t.getImage().getWidth(), t.getImage().getHeight()));
        return new Point(x, y);
}