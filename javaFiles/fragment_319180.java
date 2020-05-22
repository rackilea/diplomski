short[] source = ...;
short[] result = new short[source.length * 2];
for(int i = 0; i < source.length; ++i) {
  result[i * 2] = source[i];
  result[i * 2 + 1] = (source[i] + source[i + 1]) / 2;
}