System.out.println("Enter ten  numbers:");
    int[] n = new int[10];
    for (int i =0; i<n.length; i++) {
       n[i] = input.nextInt();
    }
    for ( int i=n.length-1; i >=  0; i-- ) {
       System.out.println( n[i] );
    }