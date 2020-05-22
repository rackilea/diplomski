public class SpinnerCustom extends JFXSpinner {
    @Override
    protected Skin<?> createDefaultSkin() {
        return new SpinnerCustomSkin(this);
    }
}