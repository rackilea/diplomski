String sql = "select name, city from student where id=?";
try (PreparedStatement ps2 = db.prepareStatement(sql)) {
    for (int i = 0; i < size; i++) {  
        int id = studList[i];
        ps2.setInt(1, id);
        try (ResultSet rs2 = ps2.executeQuery()) {
            System.out.printf("[%d] %d%n", i, id);
            while (rs2.next()) {
                System.out.printf("- %s%n", rs2.getString("name"));
                list1.add(new Student(id, rs2.getString("name"), rs2.getString("city"));
            }
        }
    }
}