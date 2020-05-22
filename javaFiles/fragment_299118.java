private String time = "Just Now";

private String how_long_ago(String created_at) {
        DateTime sinceGraduation = new DateTime(created_at, GregorianChronology.getInstance());
        DateTime currentDate = new DateTime(); //current date

        Months diffInMonths = Months.monthsBetween(sinceGraduation, currentDate);
        Days diffInDays = Days.daysBetween(sinceGraduation, currentDate);
        Hours diffInHours = Hours.hoursBetween(sinceGraduation, currentDate);
        Minutes diffInMinutes = Minutes.minutesBetween(sinceGraduation, currentDate);
        Seconds seconds = Seconds.secondsBetween(sinceGraduation, currentDate);

        Log.d("since grad", "before if " + sinceGraduation);
        if (diffInDays.isGreaterThan(Days.days(31))) {
            time = diffInMonths.getMonths() + " months ago";
            if (diffInMonths.getMonths() == 1) {
                time = diffInMonths.getMonths() + " month ago";
            } else {
                time = diffInMonths.getMonths() + " months ago";
            }
            return time;
        } else if (diffInHours.isGreaterThan(Hours.hours(24))) {
            if (diffInDays.getDays() == 1) {
                time = diffInDays.getDays() + " day ago";
            } else {
                time = diffInDays.getDays() + " days ago";
            }
            return time;
        } else if (diffInMinutes.isGreaterThan(Minutes.minutes(60))) {
            if (diffInHours.getHours() == 1) {
                time = diffInHours.getHours() + " hour ago";
            } else {
                time = diffInHours.getHours() + " hours ago";
            }
            return time;
        } else if (seconds.isGreaterThan(Seconds.seconds(60))) {
            if (diffInMinutes.getMinutes() == 1) {
                time = diffInMinutes.getMinutes() + " minute ago";
            } else {
                time = diffInMinutes.getMinutes() + " minutes ago";
            }
            return time;
        } else if (seconds.isLessThan(Seconds.seconds(60))) {
            return time;
        }
        Log.d("since grad", "" + sinceGraduation);
        return time;
    }