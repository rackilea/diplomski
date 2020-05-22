int[] arr = { 2, 4, 3, 3, 3, 3, 1, 7,8};

    int[] newArr = new int[arr.length - 1];

    int highest = arr[0], previoushighest = Integer.MIN_VALUE;

    int index = 0; // to capture position of second highest pair's second element
    int hindex = 0; // to capture position of highest pair's second element

    if(arr.length < 3) {
        System.out.println("No second highest exists");
        return;
    }

    for (int i = 0; i < arr.length - 1; i++) {
        newArr[i] = arr[i] + arr[i + 1];

        if(previoushighest < newArr[i]){
            if(highest < newArr[i]){
                previoushighest = highest;
                highest = newArr[i];
                index = hindex;
                hindex = i+1;
            } else if(highest != newArr[i]) {
                previoushighest = newArr[i];
                index = i+1;
            } else {
                continue;
            }

        }
    }

    System.out.println("Second Highest NO : "+previoushighest);

    System.out.println("no one is "+arr[index-1]+ " and no two is "+arr[index]);