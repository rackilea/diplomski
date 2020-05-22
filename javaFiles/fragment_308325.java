public interface SomeInterface {
  // any methods you want to be able to perform on the enums
}

public abstract class SomeSuperClass<T extends SomeInterface> {
  abstract T[] getSome();
}

public class SomeSubclass extends SomeSuperClass<SomeInterface> {
    public enum SomeEnum implements SomeInterface {
      testEnum {
        // interface implementation
      }
    }

    public SomeInterface[] getSome() {
        return SomeEnum.values();
    }
}