int maxrow = 0;
List<Integer> maxwidths = new ArrayList<>();
for (int i=0; i<=storage.length-1; i++){
    int maxwidth = 0;
    for (String[] inner : storage[i]){
        int width = String.join( " ", inner ).length();
        if( width > maxwidth ) maxwidth = width;
    }
    if( storage[i].length > maxrow ) maxrow = storage[i].length;
    maxwidths.add( maxwidth );
}

for (int i=0; i<=storage.length-1; i++){
    System.out.printf( "%-" + maxwidths.get(i) + "d ", i );
}
System.out.println();
for( int row = 0; row < maxrow; ++row ){
    for (int i=0; i<=storage.length-1; i++){
        String normal;
        if( row < storage[i].length ){
            normal = String.join( " ", storage[i][row] );
        } else {
            normal = "";
        }
        System.out.printf( "%-" + maxwidths.get(i) + "s ", normal );
    }
    System.out.println();
}