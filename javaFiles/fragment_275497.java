public <T extends MyInterface> void updateStuff(T stuffObject, Calendar startDate, Integer delta) {
        stuffObject.setStartDate(startDate);
        Calendar calendarEnd = Calendar.getInstance();
        calendarEnd = startDate;
        calendarEnd.add(Calendar.MONTH, delta);
        stuffObject.setEndDate(calendarEnd);
    }

    interface MyInterface{
        void setStartDate(Calendar c);
        void setEndDate(Calendar c);
    }