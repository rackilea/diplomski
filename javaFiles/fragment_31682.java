Image image = new Image("amazing-trees.jpg");
int width = (int) image.getWidth();
int height = (int) image.getHeight();
Image framedImage = transform(image, (x, y, color) -> {
    if (x < 10 || y < 10 || width - x < 10 || height - y < 10) {
        return Color.GRAY ;
    } else return color ;
});