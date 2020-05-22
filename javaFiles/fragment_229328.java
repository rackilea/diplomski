int[] data = {0,4,2,0,1,0,4,2,0,4,0,2};
int max = Integer.MIN_VALUE;
List<Integer> vals = new ArrayList<>();

for (int i=0; i < data.length; ++i) {
    if (data[i] == max) {
        vals.add(i);
    }
    else if (data[i] > max) {
        vals.clear();
        vals.add(i);
        max = data[i];
    }
}