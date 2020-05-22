List<ColumnConfig<BaseEntityProxy, ?>> columnsChamado = new ArrayList<ColumnConfig<BaseEntityProxy, ?>>();
ColumnConfig<BaseEntityProxy, String> dateColumn = new ColumnConfig<BaseEntityProxy, String>(
        new ValueProvider<BaseEntityProxy, String>() {

            private final DateTimeFormat dtFormat = DateTimeFormat.getFormat(DateTimeFormat.PredefinedFormat.DATE_FULL);

            public String getValue(BaseEntityProxy object) {
                Date initialDate =  ((TicketProxy) object).getInitialDate();
                String date = "";
                if (initialDate != null) {
                    date = dtFormat.format(initialDate);
                }
                return date;
            }

            public void setValue(BaseEntityProxy object, String initialDate) {
                if (object instanceof TicketProxy) {
                    ((TicketProxy) object).setInitialDate(dtFormat.parse(initialDate));
                }
            }

            public String getPath() {
                return "initialDate";
            }
        }, 70, "Date");

columnsChamado.add(dateColumn);

ColumnConfig<BaseEntityProxy, String> userRoomColumn = new ColumnConfig<BaseEntityProxy, String>(
        new ValueProvider<BaseEntityProxy, String>() {
            public String getValue(BaseEntityProxy object) {
                String userRoom = ((UserProxy)object).getUserRoom();
                String room = "";
                if (userRoom != null) {
                    room = userRoom;
                }
                return room;
            }

            public void setValue(BaseEntityProxy object, String userRoom) {
                if (object instanceof UserProxy) {
                    ((UserProxy)object).setUserRoom(userRoom);
                }
            }

            public String getPath() {
                return "userRoom";
            }
        }, 70, "User's Room");
columnsChamado.add(userRoomColumn);

ColumnModel<BaseEntityProxy> cm = new ColumnModel<BaseEntityProxy>(columnsChamado);