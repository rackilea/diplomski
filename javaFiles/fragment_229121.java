public <T> T query(String query, Function<ResultSet,T> function) {
     // Create Statement
     try (Statement stmt = ...) {
          // Execute Statement
          ResultSet rs = ...
          return function.apply(rs);
     }
}