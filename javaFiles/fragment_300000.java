private class Knife extends Weapon {

    // Magic numbers are bad; these are more self documenting.
    public static final int DEFAULT_RANGE = 5;
    public static final String DEFAULT_IMAGE_URL = "knife.png";

    public Knife() { this(DEFAULT_RANGE, DEFAULT_IMAGE_URL); }

    public Knife(int range, String imageName) {
        super(range, imageName);
    }
}