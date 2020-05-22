try {

        preparedStatement = dbConnection.prepareStatement(insertTableSQL);

        preparedStatement.setString(1, columns[0]);
        preparedStatement.setString(2, columns[1]);
        preparedStatement.setString(3, columns[2]);
        preparedStatement.setString(4, columns[3]);
        preparedStatement.setString(5, columns[4]);
        preparedStatement.setString(6, columns[5]);
        preparedStatement.setString(7, columns[6].replaceAll(",", ""));
        preparedStatement.setString(8, columns[7]);
        preparedStatement.setString(9, columns[8]);
        preparedStatement.setString(10, columns[9]);
        preparedStatement.setString(11, columns[10]);

        //and more inserts....
        // execute insert SQL stetement
        preparedStatement.executeUpdate();

        System.out.println("Record is inserted into Movies table!");

    }