timezoneArray = TimeZone.getAvailableIDs();
        CustomAdapter customAdapter = new CustomAdapter(getApplicationContext(), timezoneArray);
        spinner_timezone.setAdapter(customAdapter);
        for (int i = 0; i < timezoneArray.length; i++) {
            if (timezoneArray[i].equals(TimeZone.getDefault().getID())) {
                spinner_timezone.setSelection(i);
                break;
            }
        }