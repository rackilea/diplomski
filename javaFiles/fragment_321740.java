List<String[]> l = new ArrayList<>();

while (rs.next()) l.add(new String[] {
        rs.getString(1),
        rs.getString(2),
        rs.getString(3),
        rs.getString(4),
        rs.getString(5)
    });