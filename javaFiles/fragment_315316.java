if (hour >=9 && hour <11){
        timeSlots.add("XYZ");
    }

    else if (hour >= 11 && hour < 13){
        Log.d(TAG ,"Condition 1");
           timeSlots.add("YZa");
           timeSlots.add("XZa");
    }
    else if ( hour >= 13 && hour <15){
        Log.d(TAG ,"Condition 2");
        timeSlots.add("YZa");
        timeSlots.add("XZa");
        timeSlots.add("YZaZ");
    }


adp = new ArrayAdapter<String>
            (this,android.R.layout.simple_dropdown_item_1line, timeSlots);
spinnerTime.setAdapter(adp);