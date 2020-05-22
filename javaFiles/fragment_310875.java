public class NamedDragAwareImageView {

    private final ObjectProperty<NamedDragAwareImageView> source ;
    private final ObjectProperty<NamedDragAwareImageView> destination ;
    private final String name ;
    private final ImageView imageView ;

    public NamedDragAwareImageView(ObjectProperty<NamedDragAwareImageView> source,
        ObjectProperty<NamedDragAwareImageView> destination,
        String name, String resource) {

        this.source = source ;
        this.destination = destination ;
        this.name = name ;
        this.imageView = new ImageView(new Image(resource));

        imageView.setOnDragDetected(e -> {
            source.set(this);
            destination.set(null);
            imageView.startFullDrag();
        });

        imageView.setOnMouseDragReleased(e -> {
            if (source.get() != null && source.get() != this) {
                destination.set(this);
            }
        });

        // other image view config...

    }

    public ImageView getView() {
        return imageView ;
    }

    public String getName() {
        return name ;
    }

}