String convTime = null;
        try {

            String ago_date = "2020-01-14 12:52:00",  currant_date = "2020-01-18 12:52:45";

            String suffix = "Ago";

            SimpleDateFormat convert_date = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.ENGLISH);
            Calendar calendar1 = Calendar.getInstance();
            calendar1.setTime(convert_date.parse(ago_date));
            Calendar calendar2 = Calendar.getInstance();
            calendar2.setTime(convert_date.parse(currant_date));
            long millis1 = calendar1.getTimeInMillis();
            long millis2 = calendar2.getTimeInMillis();
            long diff = millis2 - millis1;
            // Calculate difference in seconds
            long diffSeconds = diff / 1000;
            // Calculate difference in minutes
            long diffMinutes = diff / (60 * 1000);
            // Calculate difference in hours
            long diffHours = diff / (60 * 60 * 1000);
            // Calculate difference in days
            long diffDays =  diff / (24 * 60 * 60 * 1000);
            // calculate how much month in days
            long multipledays = diffDays;
            int maonths = (int) multipledays / 30;
            int reamainigdays = maonths % 30;
            // Calculate  the years of monthes
            int getyears = maonths / 12;
            int reamainigmothe = getyears % 12;
            System.out.println("In calculated: ");

            if (diffSeconds<60)  {
                convTime = diffSeconds+" Seconds "+suffix;
            } else if (diffMinutes < 60) {
                convTime = diffMinutes+" Minutes "+suffix;
            } else if (diffHours < 24) {
                convTime = diffHours+" Hours "+suffix;
            } else if (diffDays >= 7) {
                if (reamainigmothe!=0 && reamainigmothe <= getyears % 12) {
                    convTime = reamainigmothe + " Years " + suffix;
                } else if (diffDays > 30) {
                    convTime = maonths + " Months " + suffix;
                } else {
                    convTime = (diffDays / 7) + " Week " + suffix;
                }
            } else if (diffDays < 7) {
                convTime = diffDays+" Days "+suffix;
            }

            System.out.println("In calculated: 222--"+convTime );

        } catch (Exception e) {
            e.printStackTrace();
        }