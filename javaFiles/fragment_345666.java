@RequestMapping(value = "/new", method = RequestMethod.POST)
   public void createTicket(@RequestParam String dto,
        @RequestParam(required = false) MultipartFile file , Authentication authentication) {
        ....
           //convert string ticket to dto using jackson databind
        .....
   }