public String timeSinceNow(Date date) {
    long test = date.getTime();
    String result = "";

    long millis = System.currentTimeMillis();

    long milliseconds = (millis - test);
    long minutes = 0;
    long hours = 0;
    long days = 0;

    days = (int) (milliseconds / (1000 * 60 * 60 * 24));
    hours = (int) ((milliseconds - (1000 * 60 * 60 * 24 * days)) / (1000 * 60 * 60));
    minutes = (int) (milliseconds - (1000 * 60 * 60 * 24 * days) - (1000 * 60 * 60 * hours)) / (1000 * 60);

    if (days > 0 || hours > 0 || minutes > 0) {
        if (hours > 0) {
            if (minutes > 0) {
                if (days == 0) {
                    if (hours == 0) {
                        if (minutes < 3) {
                            result = "Now";
                        } else {
                            result = (String) DateUtils.getRelativeTimeSpanString(test, System.currentTimeMillis(), 0);
                        }
                    } else {
                        result = (String) DateUtils.getRelativeTimeSpanString(test, System.currentTimeMillis(), 0);
                    }
                }
                else{
                        result = (String) DateUtils.getRelativeTimeSpanString(test, System.currentTimeMillis(), 0);
                    }

            }else{
                result = (String) DateUtils.getRelativeTimeSpanString(test, System.currentTimeMillis(), 0);
            }
        }else{
            result = (String) DateUtils.getRelativeTimeSpanString(test, System.currentTimeMillis(), 0);
        }
    } else {
        result = "Now";
    }

    return result;
}