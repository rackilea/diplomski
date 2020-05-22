FileChooser fileChooser = new FileChooser();
FileChooser.ExtensionFilter extFilter =new FileChooser.ExtensionFilter("png files (*.png)", "*.png");

fileChooser.getExtensionFilters().add(extFilter);
Stage primaryStage = (Stage) canvas.getScene().getWindow();

File file = fileChooser.showSaveDialog(primaryStage);
if(file != null){
        try {
            WritableImage writableImage = new WritableImage((int)canvas.getWidth(), (int)canvas.getHeight());
            canvas.snapshot(null, writableImage);
            RenderedImage renderedImage = SwingFXUtils.fromFXImage(writableImage, null);
            File file1 = new File(file.getAbsolutePath()+".png");

            file.renameTo(file1);

            ImageIO.write(renderedImage, "png", file1);


        } catch (IOException ex) {
            ex.printStackTrace();
}