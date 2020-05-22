ResultSet rs2 = stmt.executeQuery(sql + " FROM " + table);
    while (rs2.next()) {
        al.forEach((item) -> {


            // No longer complains
            System.out.println(item + ": " + rs2.getString("address"));


        });
        System.out.println();
    }