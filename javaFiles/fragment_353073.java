public static String getLocationString(Context context, @Locations int location) {

    switch (location) {
        case NOT_SPECIFIED: return context.getString(R.string.text_location_not_specified);
        case AT_HOME: return context.getString(R.string.text_location_at_home);
        case AT_WORK: return context.getString(R.string.text_location_at_work);
        case AWAY: return context.getString(R.string.text_location_away);
    }

    throw new IllegalStateException("'location' must be in range of 0-3");  /* Should never be called actually. */

}