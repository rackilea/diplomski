public final class RequestContext<T extends Cache> {
     T roleSpecificCache;

     public static final class Spec<T extends Cache>
     implements Supplier<RequestContext<T>> {
          private Spec() {
          }

          T roleSpecificCache;
     }

    private RequestContext(Spec<T> b) {
        this.roleSpecificCache = b.roleSpecificCache;
    }
}