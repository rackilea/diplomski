this.blockHeights = new int[] { 1, 2, 1, 1, 2, 1, 2, 1 };

    int x = blockHeights.length/2;

    int leftSource[] = new int[x];
    System.out.println(x);
    //go over the larger array and skip by 2
    for (int i = 0; i < blockHeights.length; i=i+2)
    {  
       leftSource[i/2] = blockHeights[i];
    }

    for (int i = 0; i < leftSource.length; i++)
    {
        System.out.println(leftSource[i]);
    }