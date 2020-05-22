rst = stmt.executeQuery("SELECT * FROM birthtable");

    while (rst.next()) 
    {
        final Person person;

        // I would use temp variables rather than passing in the result of getString directly...
        person = new Person(rst.getString(2),
                            rst.getString(3),
                            rst.getString(4),
                            rst.getString(5),
                            rst.getString(6),
                            rst.getString(7));

        // otherPerson would be passed into the method instead of the String you are passing now
        bool = person.equals(otherPerson);

        ... etc ...
    }