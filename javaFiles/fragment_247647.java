class CustomCssApplierFactory extends DefaultCssApplierFactory {
    @Override
    public ICssApplier getCustomCssApplier(IElementNode tag) {
        if ("table".equals(tag.name()) && "landscape".equals(tag.getAttribute(AttributeConstants.CLASS))) {
            return new CustomLandscapeCssApplier();
        }
        return null;
    }
}

class CustomLandscapeCssApplier extends TableTagCssApplier {
    @Override
    public void apply(ProcessorContext context, IStylesContainer stylesContainer, ITagWorker tagWorker) {
        super.apply(context, stylesContainer, tagWorker);
        IPropertyContainer container = tagWorker.getElementResult();
        if (null != container) {
            container.setProperty(10001, true);
        }
    }
}