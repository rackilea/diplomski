public static JSONArray convert(ResultSet rs) {

    Set<String> nameSet = new HashSet<>();
    Set<String> deptSet = new HashSet<>();
    JSONArray jsonArray = new JSONArray();
    JSONArray jsonArray2 = null;
    JSONObject obj = null;
    JSONObject obj2 = null;
    try {
        while (rs.next()) {
            int total_rows = rs.getMetaData().getColumnCount();
            if (nameSet.contains(rs.getString(1))) {
                if (deptSet.contains(rs.getString(3))) {
                    obj2 = new JSONObject();
                    for (int j = 3; j < total_rows; j++) {
                        obj2.put(rs.getMetaData().getColumnLabel(j + 1).toLowerCase(),
                                rs.getObject(j + 1) != null ? rs.getObject(j + 1) : "");
                    }
                    jsonArray2.put(obj2);
                } else {
                    obj2 = new JSONObject();
                    jsonArray2 = new JSONArray();
                    deptSet.add(rs.getString(3));
                    for (int j = 3; j < total_rows; j++) {
                        obj2.put(rs.getMetaData().getColumnLabel(j + 1).toLowerCase(),
                                rs.getObject(j + 1) != null ? rs.getObject(j + 1) : "");
                    }
                    jsonArray2.put(obj2);
                    obj.put(rs.getString(3), jsonArray2);
                }

            } else {
                if (obj != null) {
                    jsonArray.put(obj);
                }
                deptSet.removeAll(deptSet);
                obj = new JSONObject();
                obj2 = new JSONObject();
                jsonArray2 = new JSONArray();
                nameSet.add(rs.getString(1));
                for (int i = 0; i < 2; i++) {
                    obj.put(rs.getMetaData().getColumnLabel(i + 1).toLowerCase(),
                            rs.getObject(i + 1) != null ? rs.getObject(i + 1) : "");
                }
                if (deptSet.contains(rs.getString(3))) {

                } else {
                    deptSet.add(rs.getString(3));
                    for (int j = 3; j < total_rows; j++) {
                        obj2.put(rs.getMetaData().getColumnLabel(j + 1).toLowerCase(),
                                rs.getObject(j + 1) != null ? rs.getObject(j + 1) : "");
                    }
                }
                jsonArray2.put(obj2);
                obj.put(rs.getString(3), jsonArray2);
            }
        }
        jsonArray.put(obj);
    } catch (Exception e) {
        e.printStackTrace();
    }
    System.out.println("Final JSON: " + jsonArray);
    return jsonArray;
}