Map<Integer, List<Booking>> bookingsPerCar = ...;

// In your loop:
List<Booking> bookings = bookingsPerCar.get(results.getInt("CarID"));
if (bookings == null) {
    bookings = new ArrayList<>();
    bookingsPerCar.put(results.getInt("CarID"), bookings);
}

bookings.add(new Booking(...));