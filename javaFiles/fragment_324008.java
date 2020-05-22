int[] base = { 1, 2, 3, 4 };
    int size = 0;
    for( int count : base ){
        size += count;
    }

    int[] product = new int[size];

    int index = 0;
    for( int value : base ){
        for(int i = 0; i < value; i++){
            product[index] = value;
            index++;
        }
    }

    for( int value : product ){
        System.out.println(mine);
    }