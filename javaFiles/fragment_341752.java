try
{
  Class[] empty = {};
  final Constructor<T> c = getConstructor0(empty, Member.DECLARED);
  // removed some code that was not relevant
}
catch (NoSuchMethodException e)
{
  throw new InstantiationException(getName());
}