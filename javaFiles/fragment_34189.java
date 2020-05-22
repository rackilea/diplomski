@GetMapping(value="problemAPI/ticket", params="customerName")
public @ResponseBody String getTicketStatusByCustname(@RequestParam("customerName") String customerName)

@PostMapping(value="problemAPI/ticket")
public @ResponseBody String saveTicket(@RequestBody TicketBean bean) {
    return "Mr." + bean.getCustomerName() + " Ticket" +  bean.getTicketNo() + " has been submitted successfuly";
}