try {
        Date utilDate;
        SimpleDateFormat sqlDateFormat = new SimpleDateFormat(
                "yyyy-MM-dd HH:mm:ss");
        String sqlDate = "2014-01-01 10:10:10";
        Calendar calTempDate = Calendar.getInstance();
        calTempDate.setFirstDayOfWeek(Calendar.MONDAY);
        utilDate = sqlDateFormat.parse(sqlDate);
        calTempDate.setTime(utilDate);
        long dt = (calTempDate.getTimeInMillis()) / 1000;
        System.out.println("Timestamp is: " + dt);
    } catch (ParseException e) {
        e.printStackTrace();
    }