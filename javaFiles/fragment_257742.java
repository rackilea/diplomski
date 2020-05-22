ArrayList<String> al = new ArrayList<String>();
    while (rs.next()) {
            ArrayList<String> record = new ArrayList<String>();
            for (int i = 1; i <= columns; i++) {
                    String value = rs.String(i);
                    record.add(value);
            }
            String value = methodWhichConvertsArrayListToStringTheWayYouNeedItFormatted(record);
            al.add(value);
    }        
    return al;