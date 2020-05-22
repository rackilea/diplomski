System.out.println("the array" + Arrays.toString(value));

        connection.createStatement().execute(
                "insert into person10(personid,first_name,last_name,street,city)values('"
                        + value[0] + "','" + value[1] + "','"
                        + value[2] + "','" + value[3] + "','"
                        + value[4] + "')");
    }