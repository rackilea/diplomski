int[] ar = { 2, 1, 1, 2, 3, 3, 2, 2, 2, 1 };
    int max=0,
        maxStart=0,
        count=1;

    for(int i=1; i<ar.length; i++) {
        if (ar[i-1] == ar[i]) {
            count++;
            if(count > max) {
                max = count;
                maxStart = i-count+1;
            }
        }else {
            count=1;
        }
    }

    System.out.println("Sub array begins from " + maxStart);

    for(int i = maxStart; i < maxStart + max; i++) {
        System.out.print(ar[i] + " ");
    }


}