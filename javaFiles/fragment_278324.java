ArrayList<Double> nfit = new ArrayList<Double>();
nfit.add(2.0);
nfit.add(5.0);
nfit.add(1.0);
nfit.add(8.0);
nfit.add(3.0);
ArrayList<Double> nstore = new ArrayList<Double>(nfit); // may need to be new ArrayList(nfit)
Collections.sort(nfit);
int[] indexes = new int[nfit.size()];
for (int n = 0; n < nfit.size(); n++){
    indexes[n] = nstore.indexOf(nfit.get(n));
}
System.out.println(Arrays.toString(indexes));