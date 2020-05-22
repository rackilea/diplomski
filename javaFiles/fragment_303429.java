List< List<Integer> > list = new ArrayList< List<Integer> >();


for(int i=0; i<10; i++) // You would loop over whatever input you're processing
{                       //  but I don't know what you're doing in that part of you code
                        //  so I'll just do it 10 times.

    List<Integer> innerList = new ArrayList< Integer >();

    innerList.add( 1 );
    innerList.add( 2 );
    innerList.add( 3 );

    // etc.

    list.add( innerList );
}