public void executeCategory(category, ticketid) throws CustomException {
    try {
        //select query using connection and prepared statement
    }
    catch(SQLException e){
        e.printStackTrace();
        throw new CustomException(e);
    }
}