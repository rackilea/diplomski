Queue<int[]> worklist;
/* fill the worklist with your arrays; error if there are no arrays. */

while (worklist.size() > 1) {
    int[] first = worklist.remove();
    int[] second = worklist.remove();
    worklist.add(cartesianProduct(first, second));
}

/* Obtain the result. */
int[] result = worklist.remove();