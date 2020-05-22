String startDatetime = "11:00 PM";
        String endDatetime = "07:00 AM";
        String time_for_night = "11:05 PM";
        Integer night_extra_charges=0;
        SimpleDateFormat formatfornightcharges = new SimpleDateFormat("hh:mm aa", Locale.ENGLISH);
        try {
            Date startDate = formatfornightcharges.parse(startDatetime);
            Date selectedTimeforBooking = formatfornightcharges.parse(time_for_night);
            Date endDate = formatfornightcharges.parse(endDatetime);
            if ((selectedTimeforBooking.after(startDate)) || (selectedTimeforBooking.before(endDate))) {
                Toast.makeText(ScanDocumentsActivity.this, "200", Toast.LENGTH_SHORT).show();
                night_extra_charges = 200;
                Log.wtf("night_extra_charges",""+night_extra_charges);
            } else {
                night_extra_charges = 0;
                Log.wtf("night_extra_charges",""+night_extra_charges);
                Toast.makeText(ScanDocumentsActivity.this, "0", Toast.LENGTH_SHORT).show();
            }
        } catch (ParseException e) {
            e.printStackTrace();
        } catch (java.text.ParseException e) {
            e.printStackTrace();
        }