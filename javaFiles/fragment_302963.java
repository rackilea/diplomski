public Reservation updateReservation(ReservationUpdateRequest request) {
        Reservation reservation = reservationRepo.findById(request.getId())
            .orElseThrow(() -> new EntityNotFoundException("Reservation not found"));
        reservation.setNumberOfBags(request.getNumOfBags());
        reservation.setCheckedIn(request.getCheckedIn());
        return reservationRepo.save(reservation);
    }