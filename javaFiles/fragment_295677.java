public void insert(String Name, String NC, String acNum, String title, String day, String time, double totalPrice, ArrayList<Integer> list) throws Exception {
    System.out.println(list);
    DatabaseConnection db = new DatabaseConnection();
    try (Connection connect = db.getConnection()) {
        String sql = "insert into user_payment (user_name, ic_number, acc_number, movie_title, movie_day, movie_time, total_price, selected_seats) VALUES (?,?,?,?,?,?,?,?)";
        try (PreparedStatement ps = connect.prepareStatement(sql)) {
            ps.setString(1, Name);
            ps.setString(2, NC);
            ps.setString(3, acNum);
            ps.setString(4, title);
            ps.setString(5, day);
            ps.setString(6, time);
            ps.setDouble(7, totalPrice);
            for (Integer seat : list) {
                ps.setInt(8, seat);
                ps.addBatch();
            }
            ps.executeBatch();
         }
    }
}