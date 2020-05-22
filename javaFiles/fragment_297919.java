public void importCalendarList(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
    String code = request.getParameter("code");
    HttpTransport transport = new NetHttpTransport();
    JsonFactory jsonFactory = new JacksonFactory();

    GoogleTokenResponse res = new GoogleAuthorizationCodeTokenRequest(transport, jsonFactory, client_id, client_secret, code, redirect_uri).execute();
    ]String accessToken = res.getAccessToken();
    Calendar.Builder builder = new Calendar.Builder(transport, jsonFactory, null);  
    builder.setCalendarRequestInitializer(new CalendarRequestInitializer(accessToken));
    Calendar calendarService = builder.build();
    Calendar.CalendarList.List list = calendarService.calendarList().list();
    list.setOauthToken(accessToken);
    List <CalendarListEntry>list1=list.execute().getItems();
    String id = list1.get(0).getId();
    p.write(id);

    for(CalendarListEntry temp:list1) {
        p.println(temp.getSummary());
        temp.getId();
    }

    Event e = new Event();

    e.setSummary("Test event");
    e.setLocation("Adaptavant");

    Date startDate = new Date();
    Date endDate = new Date(startDate.getTime() + 3600000);
    DateTime start = new DateTime(startDate, TimeZone.getTimeZone("UTC"));
    e.setStart(new EventDateTime().setDateTime(start));
    DateTime end = new DateTime(endDate, TimeZone.getTimeZone("UTC"));
    e.setEnd(new EventDateTime().setDateTime(end));
    Event insertedEvent = calendarService.events().insert(id, e).setOauthToken(accessToken).execute();

    p.println(insertedEvent.getId());