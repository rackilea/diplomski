int middle;
    int right;
    int left;

    int k = 1;

    int[] a = {1,2,3,4,5,6,7,8,9,10};

    left = 0;
    right = a.length - 1;

    middle = (left + right)/2;

    for (int i = 0; i < a.length; i++ ) {
        if(a[middle] > k) {
            right = middle - 1;
        }
        if(a[middle] < k) {
            left = middle + 1;
        }
        middle=(left + right)/2;
    }

    if (k == a[middle]) {
        System.out.println("found");
    } else {
        System.out.println("not found");
    }