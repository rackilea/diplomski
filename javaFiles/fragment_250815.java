@Override
protected void doPost(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {

    //get our parameters
    String title = request.getParameter("title");
    String description = request.getParameter("description");
    String start = request.getParameter("start");
    String end = request.getParameter("end");
    String guest_no = request.getParameter("guest_no");       
    String ss = request.getParameter("startshift");
    String es = request.getParameter("endshift");
    String pos = request.getParameter("positions");

    EventsAndShifts eas = new EventsAndShifts(); //instantiate our EventsAndShifts class

    //insert into event table and return eventID
    int eventID = eas.setEventInfo(title,description,start,end,guest_no);

    //use eventID and insert into event table shift table
    eas.setShiftInfo(eventID,ss,es,pos);

    //all done
  response.sendRedirect("/viewEvents.jsp");     
}