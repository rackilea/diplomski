public static String addPrefix(String prefix, String field) {
    return new StringBuilder(prefix)
            .append(Character.toUpperCase(field.charAt(0)))
            .append(field.substring(1))
            .toString();
}

public static <T> List<T> query(Connection conn, T criteria, String operator) throws SQLException {
    List<T> list = null;
    Class<?> targetClass = criteria.getClass();
    if (targetClass.getAnnotation(Table.class) == null) throw new SQLException("ERROR: Table not defined at entity class " + targetClass.getName());
    StringBuilder SQL = new StringBuilder("SELECT * FROM ").append(targetClass.getAnnotation(Table.class).name());
    List<Object> parameters = new ArrayList<>();

    try {
        Field[] fields = targetClass.getDeclaredFields();
        for (Field field : fields) {
            if (field.getAnnotation(Column.class) == null) continue;
                Method m = targetClass.getMethod(addPrefix("get", field.getName()).toString());
                Object o = m.invoke(criteria);

                if (o == null) continue;

                if (parameters.isEmpty()) SQL.append(" WHERE"); else SQL.append(operator);
                SQL.append(" ").append(field.getAnnotation(Column.class).name()).append(" = ?");
                parameters.add(o);
        }

        try (Connection connection = IwiPrivate.getInstance().getConnection()) {
            try (PreparedStatement ps = connection.prepareStatement(SQL.toString())) {
                Integer x = 1;
                for (Field field : fields) {
                    String type = field.getType().getName();
                    Method m = targetClass.getMethod(addPrefix("get", field.getName()));
                    Object o = m.invoke(criteria);

                    if (o == null) continue;
                    if (type ==  "java.lang.String") ps.setString(x, (String) parameters.get(x));
                    else if (type == "java.lang.Integer") ps.setInt(x, (Integer) parameters.get(x));
                    else ps.setObject(x, parameters.get(x)); //Put more set traps here.
                }
                try (ResultSet rs = ps.executeQuery();) {
                    while (rs.next())
                        list.add((T) Database.mapSingle(rs, targetClass));
                }
            }
        }
    } catch (NoSuchMethodException | SecurityException | IllegalAccessException | IllegalArgumentException | InvocationTargetException ex) {
        Logger.getLogger(QueryExperiment.class.getName()).log(Level.SEVERE, null, ex);
    }
    return list;
}