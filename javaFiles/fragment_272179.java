public static int[] getDuplicatedElements(int[] n) {
    int[] nCopy = n.clone();
    int[] u = removeDuplicates(nCopy);
    System.out.println ("unique " + Arrays.toString (u));
    int count = 0;
    int limit = u.length;

    for(int i = 0; i < limit; i++) { // you must use limit instead of u.length
                                     // in order for the loop to terminate
        for(int j = 0; j < n.length; j++) {
            if(u[i] == n[j]) {
                count++;
            }
        }

        if(count == 1) {
            for(int k = i; k < limit - 1; k++) {
                u[k] = u[k + 1];
            }
            limit--;
            i--; // you must decrement i after you find a unique element in u
                 // otherwise you'll be skipping elements in the u array
        }
        count = 0;
    }

    int[] duplicated =  new int[limit];
    for(int i = 0; i < duplicated.length; i++) {
        duplicated[i] = u[i];
    }

    return duplicated;
}