// header
    for(int i = 1; i <= columnsNumber; i++) {
        System.out.print(rsmd.getColumnLabel(i)+ " ");
    }
    System.out.println();

// data
    while(rs.next()) {
        for(int i = 1; i <= columnsNumber; i++) {
            System.out.print(rs.getString(i)+ " ");
        }
        System.out.println();
    }