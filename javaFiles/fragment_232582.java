public static void importData(Context context, Map<String, String> data) {
        GtfsDatabase db = GtfsDatabase.getDatabase(context);
        db.agencyDao().deleteAll();
        db.calendarDao().deleteAll();
        db.calendarDateDao().deleteAll();
        db.feedInfoDao().deleteAll();
        db.routeDao().deleteAll();
        db.stopDao().deleteAll();
        db.stopTimeDao().deleteAll();
        db.transferDao().deleteAll();
        db.tripDao().deleteAll();

        db.agencyDao().insertAll(rawToAgencies(data.get(AGENCY_FILE)));
        db.calendarDao().insertAll(rawToCalendars(data.get(CALENDAR_FILE)));
        db.calendarDateDao().insertAll(rawToCalendarDates(data.get(CALENDAR_DATES_FILE)));
        db.feedInfoDao().insertAll(rawToFeedInfos(data.get(FEED_INFO_FILE)));
        db.routeDao().insertAll(rawToRoutes(data.get(ROUTES_FILE)));
        db.tripDao().insertAll(rawToTrips(data.get(TRIPS_FILE)));
        db.stopDao().insertAll(rawToStops(data.get(STOPS_FILE)));
        db.stopTimeDao().insertAll(rawToStopsTimes(data.get(STOP_TIMES_FILE)));
        db.transferDao().insertAll(rawToTransfers(data.get(TRANSFERS_FILE)));

        PreferenceManager.getDefaultSharedPreferences(context).edit().putBoolean(context.getString(R.string.empty), false).apply();
    }