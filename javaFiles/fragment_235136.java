JSpinner jSpinner1 = new JSpinner();
    Calendar calendar = Calendar.getInstance();
    calendar.setTime(new Date(0));
    Date earliestDate = calendar.getTime();
    calendar.add(Calendar.MINUTE, 1439); // number of minutes in a day - 1
    Date latestDate = calendar.getTime();
    SpinnerDateModel model = new SpinnerDateModel(earliestDate,
            earliestDate,
            latestDate,
            Calendar.MINUTE);
   jSpinner1.setModel(model);
   jSpinner1.setEditor(new JSpinner.DateEditor(jSpinner1, "hh:mm"));

   Date d = (Date)jSpinner1.getValue();
   Calendar c = Calendar.getInstance();
   c.setTime(d);
   c.get(Calendar.HOUR);
   c.get(Calendar.MINUTE);