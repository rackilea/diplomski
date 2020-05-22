@RequestMapping(value = "problemAPI/ticket", params="customerId", method = RequestMethod.GET)
public @ResponseBody String getTicketData(@RequestParam("customerId") int customerId){
    return "customer Id: " + customerId + " has active Ticket:1010101";
}

@RequestMapping(value = "problemAPI/ticket", params="customerName", method = RequestMethod.GET)
public @ResponseBody String getTicketStatusByCustname(@RequestParam("customerName") String customerName){
    return "Mr." + customerName + " Your Ticket is Work in Progress";
}