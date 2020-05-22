private Vehicle getVehicle(int position) {
    try {
        return Data.getVehicle(values.get(position).getId());
    } catch (ObjectNotFoundException e) {
        Log.e(TAG, e.getMessage() + "-- unable to find vehicle while getting list item vehicle for vehicles tab fragment");
        return values.get(position);
    }
}