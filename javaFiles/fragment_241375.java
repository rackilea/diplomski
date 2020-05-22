int size = 1024;
final int count = 3;
final int[] V = new int[size];

//lets fill in V randomly...
for (int i = 0; i < size; i++) {
    //random number either 0, 1, or 2
    V[i] = (int) (Math.random() * 3);
}

//this will hold our values between the phases.
int[][] totals = new int[count][size];

///////////////
// MAP PHASE //
///////////////
final int[][] kernelTotals = totals;
Kernel mapKernel = new Kernel() {
    @Override
    public void run() {
        int gid = getGlobalId();
        int value = V[gid];
        for(int index = 0; index < count; index++) {
            if (value == index)
                kernelTotals[index][gid] = 1;
        }
    }
};
mapKernel.execute(Range.create(size));
mapKernel.dispose();
totals = kernelTotals;

//////////////////
// REDUCE PHASE //
//////////////////
while (size > 1) {
    int nextSize = size / 2;
    final int[][] currentTotals  = totals;
    final int[][] nextTotals = new int[count][nextSize];
    Kernel reduceKernel = new Kernel() {
        @Override
        public void run() {
            int gid = getGlobalId();
            for(int index = 0; index < count; index++) {
                nextTotals[index][gid] = currentTotals[index][gid * 2] + currentTotals[index][gid * 2 + 1];
            }
        }
    };
    reduceKernel.execute(Range.create(nextSize));
    reduceKernel.dispose();

    totals = nextTotals;
    size = nextSize;
}
assert size == 1;

/////////////////////////////
// Done, just print it out //
/////////////////////////////
int[] results = new int[3];
results[0] = totals[0][0];
results[1] = totals[1][0];
results[2] = totals[2][0];

System.out.println(Arrays.toString(results));