public class TypeFactory implements TypeAdapterFactory {

  @SuppressWarnings("unchecked")
  public <T> TypeAdapter<T> create(final Gson gson, final TypeToken<T> type) {
    Class<? super T> t = type.getRawType();
    if(t.isAnnotationPresent(UseAccessor.class)) {
     return (TypeAdapter<T>) new AccessorBasedTypeAdaptor(gson);
    }
    return null;
  }