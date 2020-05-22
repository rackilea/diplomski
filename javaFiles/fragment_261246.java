if ((toDay.getYear() == notificationDay.getYear()) && (toDay.getMonth() == notificationDay.getMonth()) && (toDay.getDate() == notificationDay.getDate()))
    {
        Log.i("Date", "Compare : Yes");
        return "Yes";
    }
    else
    {
        Log.i("Date", "Compare : No");
        return "No";
    }