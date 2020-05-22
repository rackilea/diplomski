public class DefensiveCopyCapture<T> extends Capture<T> {
    @Override
    public void setValue(T value) {
      // create a copy of your type here; 
      // if the type happens to be a Collection like in your case, use
      // the copy constructors to create a copy
      T copy = ...; 
      super.setValue(copy);
    }
  }