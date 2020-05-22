//if you're using Eclipse, press ctrl-shift-f to "beautify" your code and make it easier to read

    int arr[] = new int[3]; //create a new array containing 3 elements
    for (int i = 0; i < 3; i++) {
        arr[i] = i;//assign each successive value of i to an entry in the array
    }
    int res = arr[0] + arr[2];//add the 0th element value to the 2nd element value, save in res
    System.out.println(res);//print res, which is == 0 + 2