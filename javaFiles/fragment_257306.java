final int MAX_NUMBER_OF_POINTERS = 20;
    int pointers = 0;

    for(int i = 0; i < MAX_NUMBER_OF_POINTERS; i++)
    {  
        if( Gdx.input.isTouched(i) ) pointers++;
    }

    System.out.println( pointers );