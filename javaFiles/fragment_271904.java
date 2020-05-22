DatabaseConnection getConnection(String arg) {
   return supplier.apply(Optional.of(arg));
}

DatabaseConnection getConnection() {
   return supplier.apply(Optional.empty());
}