public static String formatTime(Date time, Locale locale){
    String timeFormat = UserSettingManager
                           .getUserSetting(UserSettingManager.PREF_TIME_FORMAT);

    if(StringUtils.isEmptyOrWhitespace(timeFormat)){
        timeFormat = DEFAULT_TIME_FORMAT;
    }

    SimpleDateFormat formatter;

    try {
        formatter = new SimpleDateFormat(timeFormat, locale);            
    } catch(Exception e) {
        formatter = new SimpleDateFormat(DEFAULT_TIME_FORMAT, locale);
    }
    return formatter.format(time);
}