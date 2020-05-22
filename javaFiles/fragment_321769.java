private String move(int step) {
        switch(RemindMe.getDateRange()) {
            case 0:
                cal.add(Calendar.DATE, 1*step);
                break;
            case 1:
                cal.add(Calendar.DATE, 7*step);
                break;
            case 2:
                cal.add(Calendar.MONTH, 1*step);
                break;
            case 3:
                cal.add(Calendar.YEAR, 1*step);
                break;
        }
        return "";
    }