String convertSecToHoursMinute(long Sec) {
        long hours = Sec / 3600;
        long minutes = (Sec % 3600) / 60;
        long seconds = (Sec % 3600) % 60;
        String amPm = "am";
        if (minutes == 60) {
            minutes = 0;
            hours = hours + 1;
        }


        if (hours == 12) {
            amPm = "pm";
        }
        if (hours == 0) {
            hours = 12;
        }
        if (hours > 12) {
            hours = hours - 12;
            amPm = "pm";
        }
        return setZeroBeforeNine(hours) + ":" + setZeroBeforeNine(minutes) + " " + amPm;
    }

    /**
     * To set Zero before digits if less than 9(for date and time)
     *
     * @param digit : Date and time before which 0 is placed if less than 9
     * @return :return Digit placing 0 as prefix if digit is less than 9
     */
    public static String setZeroBeforeNine(long digit) {
        try {
            if (digit <= 9) {
                return "0" + digit;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "" + digit;
    }