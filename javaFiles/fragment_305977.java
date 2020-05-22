public interface SampleConverter<T, S> {
      T convert(S type);
}

import com.test.v1.A
public class TestConverter implements SampleConverter<A, com.test.v2.A> {
    public A convert(com.test.v2.A type) {
        ....
   }
}