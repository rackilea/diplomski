boolean reservationExists = false;
for(ReservationRepository r:bookedRooms){
     if (r.getRoom().equals(reservation.getRoom()) &&
        r.getDateOut().equals(reservation.getDateOut()) &&
        r.getDateIn().equals(reservation.getDateIn())) {
            reservationExists = true;
            break;
     }
}