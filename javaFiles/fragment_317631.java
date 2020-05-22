private Timetable(Parcel in)
{
    // readTypeList() needs an existing List<> to load.
    timetable = new ArrayList<Lap>();
    loggedLocations = new ArrayList<Location>();

    actLap          = in.readInt();
    in.readTypedList(timetable, Lap.CREATOR);
    in.readTypedList(loggedLocations, Location.CREATOR);
    ...