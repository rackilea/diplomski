//gets value from getEventDetailByID parameter.
        String detail = request.getParameter("getEventDetailByID");
        if (detail != null && !detail.equals("")) {
            int eventId = Integer.parseInt(request.getParameter("eventID"));
            //get event detail by id with id 
            //e.g resultObject = myMethod(detail, eventId);
        }