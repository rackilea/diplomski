public class MyImageView extends AbstractView {

    private ImageView wrappedImageView;

    public MyImageView(Context context) {
        wrappedImageView = new ImageView(context);
    }

    // TODO: Implement other constructor wrappers

    final void clearColorFilter() {
        wrappedImageView.clearColorFilter();
    }

    // TODO: Implement other method wrappers

    @Override
    public void a() {
        // specific implementation here
    }

    @Override
    public void b() {
        // specific implementation here
    }
}