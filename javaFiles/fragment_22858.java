for (int j = 0; j < openWeatherMapDaysTo.getList().size(); j++) {

                DateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

                Calendar c = Calendar.getInstance();
                c.add(Calendar.DAY_OF_YEAR, 0);
                String mNowDay = sdf.format(c.getTime());
                Date dtNow = null;

                Calendar cT = Calendar.getInstance();
                cT.add(Calendar.DAY_OF_YEAR, 1);
                String mTomorrow = sdf.format(cT.getTime());

                Date dtTomorrow = null;

                try {
                    dtNow = sdf.parse(mNowDay);
                    dtTomorrow = sdf.parse(mTomorrow);
                } catch (ParseException e) {
                    e.printStackTrace();
                }
                DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
                dateFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
                String finalDate = dateFormat.format(dtNow);
                String finalTomorrow = dateFormat.format(dtTomorrow);

                Log.d(TAG, "JSON ----------------------->: " + VolleyURL.unixTimeStampToDateTime(openWeatherMapDaysTo.getList().get(j).getDt()));
                Log.d(TAG, "VolleyURL.getDateNumber----------------------->: " + VolleyURL.getDateNumber());
                Log.d(TAG, "FINALDATE ---------> : " + finalDate);
                Log.d(TAG, "IF IC ---------> : " + VolleyURL.unixTimeStampToDateTime(openWeatherMapDaysTo.getList().get(j).getDt()));

                if (VolleyURL.unixTimeStampToDateTime(openWeatherMapDaysTo.getList().get(j).getDt()).equals(finalDate + " 12:00")) {
                    Log.d(TAG, " \n ===TRUE====: ");


                    openWeatherMapDaysTo.getList().remove(j);
                    j--;


                } else if (VolleyURL.unixTimeStampToDateTime(openWeatherMapDaysTo.getList().get(j).getDt()).equals(finalDate + " 15:00")) {
                    Log.d(TAG, " \n ===TRUE====: ");
                    openWeatherMapDaysTo.getList().remove(j);
                    j--;

                } else if (VolleyURL.unixTimeStampToDateTime(openWeatherMapDaysTo.getList().get(j).getDt()).equals(finalDate + " 18:00")) {
                    Log.d(TAG, " \n ===TRUE====: ");
                    openWeatherMapDaysTo.getList().remove(j);
                    j--;

                } else if (VolleyURL.unixTimeStampToDateTime(openWeatherMapDaysTo.getList().get(j).getDt()).equals(finalDate + " 21:00")) {
                    Log.d(TAG, " \n ===TRUE====: ");
                    openWeatherMapDaysTo.getList().remove(j);
                    j--;
                } else if (VolleyURL.unixTimeStampToDateTime(openWeatherMapDaysTo.getList().get(j).getDt()).equals(finalTomorrow + " 00:00")) {
                    Log.d(TAG, " \n ===TRUE====: ");
                    openWeatherMapDaysTo.getList().remove(j);
                    j--;
                } else if (VolleyURL.unixTimeStampToDateTime(openWeatherMapDaysTo.getList().get(j).getDt()).equals(finalTomorrow + " 03:00")) {
                    Log.d(TAG, " \n ===TRUE====: ");
                    openWeatherMapDaysTo.getList().remove(j);
                    j--;
                } else {
                    Log.d(TAG, " \n ===FALSE====: ");
                    getmOpenWeatherMapListto.add(openWeatherMapDaysTo);


                }