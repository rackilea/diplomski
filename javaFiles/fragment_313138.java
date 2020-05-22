public String editRequest() {
connection = DatabaseUtil.getServiceConnection();
    try {
        connection.setAutoCommit(false);
        executeUpdateCategory(category, ticketid);
        // Further calls
        connection.commit();
        response = "Success";
    } catch (CustomException e) {
        rollback();
    }
    return response;
}