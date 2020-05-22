public static List<Credits> getAllCredits(int id) throws SQLException {

  ...

  PreparedStatement ps=con.prepareStatement("select users.id AS organizerid, credits.invoiceid, " +
    "credits.amountin AS creditamount, attendees.name AS payee, credits.purpose, gateway.name AS gatewayname " +
    "from users, credits, attendees, gateway where credits.userid=users.id and credits.attendeeid=attendees.id " +
    "and credits.gateway=gateway.id" +
    " and users.id = ?"); // Added this extra SQL code
  ps.setInt(1, id); // Added this code to use the id parameter

  ...

}