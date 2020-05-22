@Override
public Type clone() {
  try {
    return (Type) super.clone();
  } catch (CloneNotSupporedException cnse) {
    throw new RuntimeException(cnse); // Never happens.
  }
}