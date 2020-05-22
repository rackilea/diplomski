int array[][] = {{1, 2, 3}, {2, 5, 7}, {4, 2, 1}};

List<int[]> l = new ArrayList<int[]>( Arrays.asList( array ) );  //creates an independent copy of the list
Collections.shuffle( l );

int newArray[][] = l.toArray( new int[0][0] );