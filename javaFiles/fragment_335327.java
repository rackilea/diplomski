try {
     this.connection = DriverManager.getConnection(URL, USER, PASSWORD));
     System.out.println("Database connected!");
     return this.connection;
} catch (SQLException e) {
     throw new IllegalStateException("Cannot connect the database!", e);
}