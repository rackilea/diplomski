import com.google.common.base.Function;
import com.google.common.collect.Collections2;

Collection<Number> collection = ...
return Collections2.transform(collection, new Function<Number, Integer>() {
  @Nullable
  @Override
  public Integer apply(@Nullable Number input) {
    if(input == null) {
      return null;
    }
    return input.intValue();
  }
});