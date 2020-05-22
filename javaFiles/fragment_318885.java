public static void main(String[] args) {
    nextPermutation(new int[9], 0, new boolean[9]);
}

public static void nextPermutation(int[] perm, int index, boolean[] alreadyUsed) {
    if(index == perm.length) {
        //the permutation is complete
        //you can store it or print it
    } else {

        for(int i = 0 ; i < alreadyUsed.length ; i++) {
            if(alreadyUsed[i]) continue;

            perm[index] = i+1;

            boolean[] newAlreadyUsed = Arrays.copyOf(alreadyUsed, alreadyUsed.length);
            newAlreadyUsed[i] = true;
            nextPermutation(Arrays.copyOf(perm, perm.length), index+1, Arrays.copyOf(newAlreadyUsed, newAlreadyUsed.length));
        }
    }
}