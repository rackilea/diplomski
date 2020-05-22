public class CrabGroup extends HBox {

    private static final Image c = new Image("File:crab.gif");

    public CrabGroup() {
        setSpacing(50);
    }

    /**
     * Adds a crab
     */
    public void addCrab() {
        if(getChildren().size() < 6) {
            ImageView image = new ImageView(c);
            image.setFitWidth(100);
            image.setFitHeight(100);
            crabList.add(image);
        }
    }

    /** 
     * Deletes a crab
     */
    public void deleteCrab() {
        if(!getChildren().isEmpty()) {
            getChildren().remove(getChildren().size() - 1);
        }
    }

}