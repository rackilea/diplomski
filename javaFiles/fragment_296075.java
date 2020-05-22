while(rs.next()) {

    for (int column = 1; column <= numberOfColumns; column++) {

        if(column > 1) System.out.print(", ");
        System.out.print(rs.getString(column));
    }
}