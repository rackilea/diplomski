HashMap<Integer,ArrayList<Person>> monthMap = new HashMap<>();

    Calendar cal = Calendar.getInstance(); //expensive operation... use sparingly

    for (Person p : people){
        cal.setTime(p.getDate()); //Sets this Calendar's time with the person's Date.
        int month = cal.get(Calendar.MONTH); //gets int representing the month
        ArrayList<Person> monthList = monthMap.get(month); 

        //initialize list if it's null (not already initialized)
        if(monthList == null) {
            monthList = new ArrayList<>(); 
        }

        monthList.add(p); //add the person to the list

        // put this month's people list into the map only if it wasn't there to begin with
        monthMap.putIfAbsent(month, monthList); 
    }