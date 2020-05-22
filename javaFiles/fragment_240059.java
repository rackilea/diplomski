for (int i = 1; i <= 14; i++) {              
        String month_name1 = monthDate.format(cal.getTime());            
        allDates.add(month_name1);
        cal.add(Calendar.MONTH, -1);
        month_name1 = monthDate.format(cal.getTime());
        allDates.add(month_name1);            
        cal.add(Calendar.DATE, -1);   
    }
    for (int j = 0; j < allDates.size() - 1; j+=2) {
        JSONObject dateRange = new JSONObject();
        dateRange.put("until", allDates.get(j)); 
        System.out.println("to date:"+allDates.get(j));
        dateRange.put("since", allDates.get(j + 1));
        System.out.println("from date:"+ allDates.get(j + 1));
    }