if (weight<40 == false) {
    String weightParam = " AND users.weight <= ?";
    selectSQL = selectSQL.concat(weightParam);
    System.out.println(selectSQL);

    try {
        ++iterator;
        System.out.println(iterator);
        /* Note : Change Here */
        preparedStatement = con.prepareStatement(selectSQL);
        preparedStatement.setInt(iterator, weight);
    } catch (SQLException e) {
        System.out.println("second catch block");
        e.printStackTrace();
    }
    System.out.println(selectSQL);
}