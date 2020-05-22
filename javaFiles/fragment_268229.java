void func()
{
  int x = 3;
  int[] holder = [x];
  add_one(holder);
  // now holder[0] is 4.  x is still 3.
}

// container here is a copy of the reference holder in the calling scope.
// both container and holder point to the same underlying array object
void add_one(int[] container)
{
    container[0]++;
}