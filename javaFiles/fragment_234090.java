<%  
    String operation = request.getParameter("operation");
    if ( operation != null and operation.equals( "addreservation" ) )
    {
        String d = request.getParameter("day");
        String m = request.getParameter("month");
        String y = request.getParameter("year");
        String r = request.getParameter("roomNo");
        String n = request.getParameter("nights");
        String rt = request.getParameter("rType");
        String em = String.valueOf(request.getAttribute("email"));

        ReservationDb rd = new ReservationDb();
        rd.insert(d, m, y, r, n, rt, em);
    }
    else
    {
        // ignore reading parameters
    }
;
%>