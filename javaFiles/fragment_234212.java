private static double[] fromList(List<Double> al) {
  double[] out = new double[al.size()];
  for (int i = 0;i < al.size(); i++) {
    out[i] = al.get(i);
  }
  return out;
}