@PutMapping("/reservations/{id}")
public ResponseEntity<Reservation> updateReservation(@PathParam("id") Long id, ReservationUpdateRequest request) {
     return reservationRepo.findById(id)
         .map(r -> {
             r.setNumberOfBags(request.getNumOfBags());
             r.setCheckedIn(request.getCheckedIn());
             return ResponseEntity.ok().body(reservationRepo.save(r));
         }).orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
}