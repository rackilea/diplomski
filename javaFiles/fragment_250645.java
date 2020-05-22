public final class RequestMetaFactory {

  public RequestFactory<T> newFactory(T req) {
    if (req instanceof String) {
      return new StringRequestFactory((String)req);
    }

    if (req instanceof Integer) {
      return new IntegerRequestFactory((Integer)req);
    }

    throw new IllegalArgumentException(req.getClass() + " not a supported arg type");
  }

}