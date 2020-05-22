String date = year+"-"+month+"-"+dayOfMonth;
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd", 

    Locale.getDefault());
            Date datex = null;
            try {
                datex = format.parse(date);
                String formattedDate=format.format(datex);
                Log.e("FormattedDate",formattedDate);
            } catch (ParseException e) {
                e.printStackTrace();
            }