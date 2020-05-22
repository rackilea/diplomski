Collections.sort(results, new Comparator<Result>() {
            @SuppressLint("SimpleDateFormat")
            @Override
            public int compare(Result t1, Result t2) {
                if (t1.getCreatedDate() != null) {
                    String sDate1 = t1.getCreatedDate();
                    String date2 = t2.getCreatedDate();
                    java.util.Date date1 = null;
                    Date date2s = null;
                    try {
                        date1 = new SimpleDateFormat("d mmm,yyyy").parse(sDate1);
                        date2s = new SimpleDateFormat("d mmm,yyyy").parse(date2);
                    } catch (ParseException e) {
                        e.printStackTrace();
                    }

                    if (date1 != null && date2s != null) {
                        return date2s.compareTo(date1);
                    }
                    return 0;
                } else return 0;
            }
        });