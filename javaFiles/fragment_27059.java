public enum MyConstants {
    CST1(new Image("someImage.jpg")),
    CST2(new Image("someOtherImage.jpg"));

    public final Image img;

    private MyConstants(Image img) {
        this.img = img;
    }
}