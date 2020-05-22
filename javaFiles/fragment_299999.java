private class Weapon {

    protected int range;  // units?  feet?  miles?  furlongs?
    protected Image image;

    public Weapon(int range, String imageName) {
        this.range = range;
        image = new Image(this.getClass().getResource(imageName).toExternalForm());  // what happens if imgUrl is null?  Not a URL?
    }
}