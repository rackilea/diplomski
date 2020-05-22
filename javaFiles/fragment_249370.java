public class MyImageView extends ImageView {

    public MyImageView(Element elem) {
        super(elem);
    }

    @Override
    public Icon getNoImageIcon() {
        return null;
    }

    @Override
    public Icon getLoadingImageIcon() {
        return null;
    }
}