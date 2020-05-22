@PostMapping("/url")
public ResponseEntity bookTickets(@RequestBody Map<String, PeopleType> peopleTypes, HttpSession session) {
    Tickets tickets = new Tickets();
    tickets.setPeopleTypes(peopleTypes);
    ...
}