@GetMapping("/findWithRange")
public ResponseEntity<List<Appointment>> findAllWithCreationRange(@RequestParam("start") @DateTimeFormat("yyyy-MM-dd") Date start, @RequestParam("end") @DateTimeFormat("yyyy-MM-dd") Date end) {

    List<Appointment> appointments = service.findAllWithCreationRange(start, end);

    if (Objects.isNull(appointments)) {
        ResponseEntity.badRequest().build();
    }

    return ResponseEntity.ok(appointments);
}