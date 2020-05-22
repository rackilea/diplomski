class X
{
  static int s; // can be accessed as X.s without object
  final int f = 7; // can't be assigned a different value
  const int c; // doesn't compile
}