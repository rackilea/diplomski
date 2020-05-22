package mypackage;

...

public ChooseSchemeController {

    private static final Random random = new Random();
    private static final int TOTAL_SCHEME = 26; // you don't want to use a wrapper type here

    @FXML
    private ImageView scheme1;

    @FXML
    private void initialize() {
        chooseRandomImage(scheme1);
    }

    private void chooseRandomImage(ImageView iv) {
        int imageNumber = random.nextInt(TOTAL_SCHEME);

        System.out.println(imageNumber);
        Image schemeImage = new Image("GUIfiles/imgs/schemecard/val5/"+ imageNumber + ".jpg");

        iv.setImage(schemeImage);
    }

}