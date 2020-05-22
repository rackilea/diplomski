public void query(String query, Consumer<ResultSet> consumer) {
     // Create Statement
     try (Statement stmt = ...) {
          // Execute Statement
          ResultSet rs = ...
          consumer.accept(rs);
     }
}