public final class SomeImplementation1 implements MyInterface<String> {
   @Override
   public String run(final String arg) {
       return arg;
   }

   @Override
   public Class<String> type() {
       return String.class;
   } 
}

@SuppressWarnings({"unchecked"})
public static  <T> String run(final T arg) {
    for (final MyInterface<?> element : elements) {
        if (element.type().isAssignableFrom(arg.getClass())) {
            return ((MyInterface<T>) element).run(arg);
        }
    }
    throw new IllegalArgumentException("No element found.");
}