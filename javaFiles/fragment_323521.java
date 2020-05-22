public abstract class LoadableBuilder<C extends ILoadable,
    T extends ILoadableBean, B extends ILoadableBuilder<C,T,B>>
    implements ILoadableBuilder<C,T,B> {
    //...
}

public class BasicLoadableBuilder<C extends ILoadable, T extends ILoadableBean>
    extends LoadableBuilder<C,T, BasicLoadableBuilder<C,T>> {
}