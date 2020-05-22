int l1 = ArrayList1.size(); int l2 = ArrayList2.size();
int max = Math.max(l1, l2);
ArrayList<Integer> ArrayListResult = new ArrayList<Integer>(max);


for (int i = 0; i<max; i++ ) {

    ArrayListResult.set(i,0);
    if(i < l1) {
         ArrayListResult.set(i,ArrayList1.get(i)+ArrayListResult.get(i));
    }
    if(i < l2) {
         ArrayListResult.set(i,ArrayList2.get(i)+ArrayListResult.get(i));
    }
}