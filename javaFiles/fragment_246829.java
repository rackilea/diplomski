for (int i=0; i < studentID.length; i++) {
    FreeBean free = new FreeBean();
    free = GenerateScheduleDAO.getFree(supervisorID[i],examinerID[i]);

    int SVavailableID = free.getAvailableID();
    int EXavailableID = free.getAvailableID();
    Date FreeDate = free.getFreeDate();

    // handle the edge case here
    if (SVavailableID == 0 && EXavailableID == 0) {
        free = GenerateScheduleDAO.getOtherFree(supervisorID[i],examinerID[i]);

        SVavailableID = free.getAvailableID();
        EXavailableID = free.getAvailableID();
    }

    // now print out each record only one time
    out.println("<tr>");
    out.println("<td>"+ studentID[i]+"</td>");
    out.println("<td> Hello </td>");
    out.println("<td>"+ supervisorID[i] +"</td>");
    out.println("<td>"+ examinerID[i] +"</td>");
    out.println("<td>"+ SVavailableID+"</td>");
    out.println("<td>"+ EXavailableID+"</td>");
    out.println("<td>"+ FreeDate+"</td>");
    out.println("</tr>");
}