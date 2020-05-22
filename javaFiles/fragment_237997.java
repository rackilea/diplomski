long[] values = new long[2*numbercount+1];
for (int a = 0; a < numbercount; ++a) {
  values[2*a+0] = 100;
  values[2*a+1] = value;
}
values[values.length-1] = 100;