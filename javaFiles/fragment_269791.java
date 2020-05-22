ResultSet rs = ...;
    Map<String, Object> values = new HashMap<String, Object>();
    while (rs.next()) {
        Object o = null;
        String type = rs.getString("data_type");
        switch(type) {
        case "text":
            o = rs.getString("value");
            break;
        case "boolean":
            o = "true".equalsIgnoreCase(rs.getString("value"));
            break;
        case "int":
            o = rs.getInt("value");
            break;
        }
        values.put(rs.getString("description"), o);
    }