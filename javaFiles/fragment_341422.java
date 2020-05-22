private void setCalendar(){
        Map<Date, Drawable> successMap = new HashMap<>();
        Map<Date, Drawable> failureMap = new HashMap<>();
        //For success days
        for(int i=0; i<successDays.size(); i++){
            successMap.put(successDays.get(i), getResources().getDrawable(R.drawable.green_circular));
        }
        //For failure days
        for(int i=0; i<failureDays.size(); i++){
            failureMap.put(failureDays.get(i), getResources().getDrawable(R.drawable.red_circular));
        }
        successMap.putAll(failureMap);
        caldroidFragment.setBackgroundDrawableForDates(successMap);
        caldroidFragment.refreshView();
    }