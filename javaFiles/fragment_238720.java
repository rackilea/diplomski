int nCol = result.getMetaData().getColumnCount();
List<String[]> table = new ArrayList<>();
while( result.next()) {
    String[] row = new String[nCol];
    for( int iCol = 1; iCol <= nCol; iCol++ ){
            Object obj = result.getObject( iCol );
            row[iCol-1] = (obj == null) ?null:obj.toString();
    }
    table.add( row );
}

// print result
for( String[] row: table ){
    for( String s: row ){
        System.out.print( " " + s );
    }
    System.out.println();
}