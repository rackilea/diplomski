public void formatDate() {
        try {
            Calendar c = Calendar.getInstance();
            SimpleDateFormat df = new SimpleDateFormat("MM.dd.yyyy");
            // Get current Date in right format...
            Date date = df.parse("10.12.2013");

            // Get the date of the event in the right format ...
            SimpleDateFormat dff = new SimpleDateFormat("yyyy-MM-dd");

            String formattedDateEvent = dff.format(date);
            Log.v(">>>>>>>>", formattedDateEvent);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }