double[][] a = new double[constraint_temp.size()][];
for (int i = 0; i < a.length; i++) {
  a[i] = fromList(constraint_temp.get(i));
}
double[] b = fromList(B_value_temp);
double[] c = fromList(obj_func);
Simplex smlpx = new Simplex(a,b,c);