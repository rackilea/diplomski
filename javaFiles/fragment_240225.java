public class FadeInAnimation extends Animation {
    private final UIObject uiObject;

    FadeInAnimation(final UIObject uiObject) {
      this.uiObject = uiObject;
    }

    @Override
    protected void onUpdate(final double progress) {
      uiObject.getElement().getStyle().setOpacity(progress);
    }
}