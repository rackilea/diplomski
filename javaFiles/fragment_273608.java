public class MyRulerColumn extends AbstractContributedRulerColumn {
    private IVerticalRulerColumn delegate = new AbstractRulerColumn() { … }
    public void setModel(IAnnotationModel model) {
        delegate.setModel(model);
    }
    …
}