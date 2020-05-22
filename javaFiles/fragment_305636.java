@PutMapping("/{id}/update")
    @JsonDeserialize(as = Boolean.class)
    public ResponseEntity<Appointment> updateAppointmentStatus(@PathVariable Long id, @RequestBody Status status) {

        Appointment appointment = service.findById(id).get();
        appointment.setStatus(status);

        service.save(appointment);
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(appointment);
    }