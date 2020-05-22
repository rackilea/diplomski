try {
   // Something that produces multiple SQLExceptions
} catch (SQLException e) {
   SQLException current = e;
   do {
      // do something with current
   } while ((current = current.getNextException()) != null)
}