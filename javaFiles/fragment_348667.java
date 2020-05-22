static int flu_in_hamamatsu(int day) {
  int i,r;

  r = initial;

  for( i = 0; i < day; i++ ) {
    r = one_percent_increase_of(r);
  }

  return r;
}