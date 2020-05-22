public abstract class BaseView<T extends BaseTemplate> {

    private final T template;

    protected BaseView(T template) {
        this.template = template;
    }

    //common view methods operating using T etc.
}

public final class ViewA extends BaseView<TemplateA> {

    public ViewA() {
        super(new TemplateA()); //or wherever templates come from
    }

    // ViewA specific stuff
}