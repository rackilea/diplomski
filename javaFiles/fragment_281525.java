@Override
public void setValue(T value) {
  if(!hasCaptured()) {
    super.setValue(value);
  }
}