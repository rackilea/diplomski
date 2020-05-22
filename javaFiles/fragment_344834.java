ArrayList<int[]> pairs_ref = new ArrayList<int[]>(); //note the use of generics in the parameter
int[] singlePair_ref = new int [2];
singlePair_ref[0] = 15;
singlePair_ref[1] = 0;

pairs_ref.add(singlePair_ref);

//simplification here
for (int[] arr : pairs_ref){
    System.out.println("Live: "+arr[0]+"  "+arr[1]);
}