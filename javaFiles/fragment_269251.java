// AndroidInjector.Builder
abstract class Builder<T> implements AndroidInjector.Factory<T> {
  @Override
  public final AndroidInjector<T> create(T instance) {
    seedInstance(instance);
    return build();
  }