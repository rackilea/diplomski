String abc = "1,2,3,4";

    int i = 0;
    StringTokenizer st = new StringTokenizer(abc,","); 
    int array[] = new int[st.countTokens()];
    while (st.hasMoreTokens()) {
        array[i] = Integer.parseInt(st.nextToken().toString());
        i++;
    }