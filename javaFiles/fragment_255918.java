NextPreWeekday = getWeekDay();
        firstDayOfWeek = CommonMethod.convertWeekDays(NextPreWeekday [0]);
        lastDayOfWeek = CommonMethod.convertWeekDays(NextPreWeekday [6]);
        textViewDate.setText(firstDayOfWeek + "-" + lastDayOfWeek + " " + CommonMethod.convertWeekDaysMouth(NextPreWeekday [6]));

        textViewSun.setText(CommonMethod.convertWeekDays(NextPreWeekday [0]) + "\nSun");
        textViewMon.setText(CommonMethod.convertWeekDays(NextPreWeekday [1]) + "\nMon");
        textViewTue.setText(CommonMethod.convertWeekDays(NextPreWeekday [2]) + "\nTue");
        textViewWed.setText(CommonMethod.convertWeekDays(NextPreWeekday [3]) + "\nWeb");
        textViewThu.setText(CommonMethod.convertWeekDays(NextPreWeekday [4]) + "\nThu");
        textViewFri.setText(CommonMethod.convertWeekDays(NextPreWeekday [5]) + "\nFri");
        textViewSat.setText(CommonMethod.convertWeekDays(NextPreWeekday [6]) + "\nSat");







 public static String convertWeekDays(String date)
    {
        String formattedDate = null;
        try
            {
                SimpleDateFormat originalFormat = new SimpleDateFormat("yyyy-MM-dd" , Locale.ENGLISH);
                SimpleDateFormat targetFormat = new SimpleDateFormat("dd");
                Date date12 = originalFormat.parse(date);
                formattedDate = targetFormat.format(date12);
            } catch (Exception e)
            {
                e.printStackTrace();
            }

        return formattedDate;

    }



public static String convertWeekDaysMouth(String date)
    {
        String formattedDate = null;
        try
            {
                SimpleDateFormat originalFormat = new SimpleDateFormat("yyyy-MM-dd" , Locale.ENGLISH);
                SimpleDateFormat targetFormat = new SimpleDateFormat("MMM yyyy");
                Date date12 = originalFormat.parse(date);
                formattedDate = targetFormat.format(date12);
            } catch (Exception e)
            {
                e.printStackTrace();
            }

        return formattedDate;

    }