JCalendar calendar = new JCalendar();
    calendar.setSelectableDateRange(new Date(),new SimpleDateFormat("MM-DD-YYYY").parse("05-05-2015"));

    PropertyChangeListener calendarChangeListener  = new PropertyChangeListener() {
        @Override
        public void propertyChange(PropertyChangeEvent evt) {
            Date selectedDate = ((JCalendar)evt.getSource()).getDate();
        }
    };
    calendar.addPropertyChangeListener("calendar",calendarChangeListener);