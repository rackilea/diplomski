String action = request.getParameter("action");
        if (action.equalsIgnoreCase("GetById")) {
            int eventId = Integer.parseInt(request.getParameter("eventID"));
            //get event detail by id with id 
            //e.g resultObject = getById(eventId);
        } else if (action.equalsIgnoreCase("GetAllEvents")) {
            //Get all events
            //e.g resultObject = GetAllEvents();
        } else {
        }