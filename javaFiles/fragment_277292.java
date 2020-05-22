Date currentTrueSystemDate = Calendar.getInstance().getTime();
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MMM-yyyy hh:mm:ss");
        sdf.setTimeZone(TimeZone.getTimeZone("Asia/Kuwait"));
        String newConvertedDate = sdf.format(currentTrueSystemDate.getTime());
        System.out.println(newConvertedDate);
        try {
            sdf = new SimpleDateFormat("dd-MMM-yyyy hh:mm:ss");
            Date newConvertedDate2 = sdf.parse(newConvertedDate);
            System.out.println(newConvertedDate2);
        } catch (ParseException e) {
            System.out.println(e.getLocalizedMessage());
        }