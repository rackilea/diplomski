// A column named "date" is probably illegal and not very illustrative.  "date" is a keyword for most databases.
    // Building a string that never changes again and again is a waste of CPU and heap
    private static final String INSERT_SQL =  "insert into Entry(date,equipment) values(?,?)";

    PreparedStatement ps = db.prepareStatement(INSERT_SQL);

    // Use the type system properly.  Dates should be DATE type columns in a database.  Why string?    
    ps.setDate(entryDate);

    // You shouldn't want to insert an array of values; that's not normalized.
    ps.setString(equipmentEnumValue.name());