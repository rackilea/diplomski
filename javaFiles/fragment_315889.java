public void create(Integer ticketNumber, Date timeOpened, String priorityLevel, 
                   String caseOwner) {
    String sql = "insert into user_ticket (ticket_number, opened, priority, case_owner) 
                  values (?, ?, ?, ?)";
    Object[] params = {ticketNumber, timeOpened, priorityLevel, caseOwner};
    jdbcTemplateObject.update(sql, params);

    System.out.println("Created Record Ticket Number = " + ticketNumber + 
                       " Time Opened = " + timeOpened + "Priority Level " + 
                       priorityLevel + " Case Owner: " + caseOwner);
}