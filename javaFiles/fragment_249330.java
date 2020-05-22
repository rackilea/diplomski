class BookingService {
    public void insert(Booking t) {
        synchronized(this) {
            if(available(t.getTutor(), t.getDate(), t.getTime())) {
                bookingDao.insert(t);
            } else {
                // reject
            }
        }
    }
}