public abstract class AView<V extends AView<V, C>,
                            C extends AController<V, C>> {
    protected C controller;
}

public abstract class AController<V extends AView<V, C>,
                                  C extends AController<V, C>>
        implements IController {
    protected V view;
}