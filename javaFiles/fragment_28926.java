try {
    f.conn = DriverManager.getConnection(stringaConn);
    System.out.println("Aperta la connessione");
} catch (SQLException e) {
    System.out.println("Stringa di connessione errata");
}