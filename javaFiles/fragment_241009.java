public static void main(String[] args) {
    int[] array = {1, 2, 3, 4, 5};
    int n = 2;
    subset(array, n, 6, 0, new int[n], 0);
}

public static int[] subset(int[] array, int n, int sum, int count, int[] subarray, int pos) {
    subarray[count] = array[pos];
    count++;

    //If I have enough numbers in my subarray, I can check, if it is equal to my sum
    if (count == n) {
        //If it is equal, I found subarray I was looking for
        if (addArrayInt(subarray) == sum) {
            return subarray;
        } else {
            return null;
        }
    }

    for (int i = pos + 1; i < array.length; i++) {
        int[] res = subset(array, n, sum, count, subarray.clone(), i);
        if (res != null) {
            //Good result returned, so I print it, here you should merge it
            System.out.println(Arrays.toString(res));
        }
    }

    if ((count == 1) && (pos < array.length - 1)) {
        subset(array, n, sum, 0, new int[n], pos + 1);
    }

    //Here you should return your merged result, if you find any or null, if you do not
    return null;
}

public static int addArrayInt(int[] array) {
    int res = 0;
    for (int i = 0; i < array.length; i++) {
        res += array[i];
    }
    return res;
}