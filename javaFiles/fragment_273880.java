public void onEventMove(ScheduleEntryMoveEvent scheduleEntryMoveEvent)
   {
      Expense exp = (Expense) scheduleEntryMoveEvent.getScheduleEvent()
        .getData();
      System.out.println("Expense Date Before="+exp.getDate())
      java.util.Calendar newCal = new GregorianCalendar();
      newCal.setTime(exp.getDate());
      newCal.add(Calendar.DATE, (-1 * scheduleEntryMoveEvent.getDayDelta()));
      newCal.add(Calendar.MINUTE, (-1 * scheduleEntryMoveEvent.getMinuteDelta()));
      exp.setDate(newCal.getTime());
      System.out.println("Expense Date After="+exp.getDate());
   }