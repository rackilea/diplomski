ImageView imageView = new ImageView();
List<Image> images = new ArrayList<>();
// populate images...

Transition animation = new Transition() {
    {
        setCycleDuration(Duration.millis(1000)); // total time for animation
    }

    @Override
    protected void interpolate(double fraction) {
        int index = (int) (fraction*(images.size()-1));
        imageView.setImage(images.get(index)); 
    }
}
animation.play();