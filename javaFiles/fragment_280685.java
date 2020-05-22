try {
        switch (day) {
                    case Calendar.FRIDAY:
                        if (timeOfDay > 22 || timeOfDay < 16) {
                            countuser = 0;
                        } else if (timeOfDay >= 16 || timeOfDay <= 22) {
                            countuser = 1;
                        }
                        break;
                    case Calendar.MONDAY:
                        if (timeOfDay > 22 || timeOfDay < 16) {
                            countuser = 2;
                        } else if (timeOfDay >= 16 || timeOfDay <= 22) {
                            countuser = 3;
                        }
                        break;
                    case Calendar.SATURDAY:
                        if (timeOfDay > 22 || timeOfDay < 16) {
                            countuser = 4;
                        } else if (timeOfDay >= 16 || timeOfDay <= 22) {
                            countuser = 5;
                        }
                        break;
                    case Calendar.SUNDAY:
                        if (timeOfDay > 22 || timeOfDay < 16) {
                            countuser = 6;
                        } else if (timeOfDay >= 16 || timeOfDay <= 22) {
                            countuser = 7;
                        }
                        break;
                    case Calendar.THURSDAY:
                        if (timeOfDay > 22 || timeOfDay < 16) {
                            countuser = 8;
                        } else if (timeOfDay >= 16 || timeOfDay <= 22) {
                            countuser = 9;
                        }
                        break;
                    case Calendar.TUESDAY:
                        if (timeOfDay > 22 || timeOfDay < 16) {
                            countuser = 10;
                        } else if (timeOfDay >= 16 || timeOfDay <= 22) {
                            countuser = 11;
                        }
                        break;
                    case Calendar.WEDNESDAY:
                        if (timeOfDay > 22 || timeOfDay < 16) {
                            countuser = 12;
                        } else if (timeOfDay >= 16 || timeOfDay <= 22) {
                            countuser = 13;
                        }
                        break;
        }
    } catch(Exception e){
        e.printStackTrace();
    }