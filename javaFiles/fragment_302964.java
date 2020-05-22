public ResponseEntity<Reservation> updateReservation(ReservationUpdateRequest request) {
     return reservationRepo.findById(request.getId())
         .map(r -> {
              r.setNumberOfBags(request.getNumOfBags());
              r.setCheckedIn(request.getCheckedIn());
              return ResponseEntity.ok().body(reservationRepo.save(r));
          }).orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }