public void querySQL(String COMMANDSQL) {
    ...
    try {
        ...
    } catch (Exception e) {
        String errorMessage = (e.getMessage() != null) ? e.getMessage() : "Unknown error";
        Log.e("ERROR", errorMessage);
   }
}