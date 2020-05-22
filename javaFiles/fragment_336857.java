List<ColumnConfig<TicketWithUserProxy, ?>> columnsChamado = new ArrayList<ColumnConfig<TicketWithUserProxy, ?>>();

ColumnConfig<TicketWithUserProxy, String> dateColumn = new ColumnConfig<TicketWithUserProxy, String>(
        new ValueProvider<TicketWithUserProxy, String>() {

            private final DateTimeFormat dtFormat = DateTimeFormat.getFormat(DateTimeFormat.PredefinedFormat.DATE_FULL);

            public String getValue(TicketWithUserProxy object) {
                Date initialDate =  object.getTicketProxy().getInitialDate();
                String date = "";
                if (initialDate != null) {
                    date = dtFormat.format(initialDate);
                }
                return date;
            }

            public void setValue(TicketWithUserProxy object, String initialDate) {
                object.getTicketProxy().setInitialDate(dtFormat.parse(initialDate));
            }

            public String getPath() {
                return "initialDate";
            }
        }, 70, "Date");

columnsChamado.add(dateColumn);

ColumnConfig<TicketWithUserProxy, String> userRoomColumn = new ColumnConfig<TicketWithUserProxy, String>(
        new ValueProvider<TicketWithUserProxy, String>() {
            public String getValue(TicketWithUserProxy object) {
                String userRoom = object.getUserProxy().getUserRoom();
                String room = "";
                if (userRoom != null) {
                    room = userRoom;
                }
                return room;
            }

            public void setValue(TicketWithUserProxy object, String userRoom) {
                object.getUserProxy().setUserRoom(userRoom);
            }

            public String getPath() {
                return "userRoom";
            }
        }, 70, "User's Room");
columnsChamado.add(userRoomColumn);
ColumnModel<TicketWithUserProxy> cm = new ColumnModel<TicketWithUserProxy>(columnsChamado);