@FXML
    private ImageView1 imageView;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        File file = new File("F:/a.jpg");
        Image image = new Image(file.toURI().toString());
        imageView.setImage(image);
    }