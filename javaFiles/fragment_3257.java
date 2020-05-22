protected void onPostExecute(ArrayList<HashMap<String, String>> args) {

            for (i = 0; i < arraylist.size(); i++) {
                Calendar cal = Calendar.getInstance();

                HashMap<String, String> map = arraylist.get(i);

                SimpleDateFormat simpleDateFormat = new SimpleDateFormat(
                        "yyyy-MM-dd", Locale.getDefault());
                try {
                    Date orangeDate = simpleDateFormat
                            .parse(map.get("dtstart"));

                    // Max date is next 7 days
                    /*
                     * cal = Calendar.getInstance(); cal.add(Calendar.DATE, 2);
                     * Log.e("fecha", "" + redDate); Date orangeDate =
                     * cal.getTime();
                     */
                    Log.e("fecha", "" + orangeDate);
                    String color = map.get("color");
                    if (caldroidFragment != null) {
                        if (color.equals("red")) {
                            caldroidFragment.setBackgroundResourceForDate(
                                    R.color.red, orangeDate);
                            caldroidFragment.setTextColorForDate(R.color.white,
                                    orangeDate);
                        }
                        if (color.equals("orange")) {
                            caldroidFragment.setBackgroundResourceForDate(
                                    R.color.orange, orangeDate);
                            caldroidFragment.setTextColorForDate(R.color.white,
                                    orangeDate);
                        }
                    }
                    ArrayList<Date> disabledDates = new ArrayList<Date>();

                    for (int i = 4; i < 8; i++) {
                        cal = Calendar.getInstance();
                        cal.add(Calendar.DATE, i);
                        disabledDates.add(cal.getTime());
                    }

                    caldroidFragment.setDisableDates(disabledDates);
                    caldroidFragment.refreshView();

                } catch (ParseException e) { // Insert this block.
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        }