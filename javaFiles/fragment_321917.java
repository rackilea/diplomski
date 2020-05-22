HashSet<Integer> hash = new HashSet<>();
int q =Math.abs(y-u);
if(y!=u && q==1 ) {
    hash.add(seq[y]);
    hash.add(seq[u]);
}
if(hashSets.add(hash)){
    System.out.println(seq[y]+" "+seq[u]);
    count++;
}