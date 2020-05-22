@PostMapping(value="/proposal", produces = "application/json", consumes = "application/json")
   @ResponseBody
   public ResponseEntity<?> saveProposal(HttpServletRequest request,
           HttpServletResponse response,@RequestBody Proposal proposal ) {

       long customerId = proposal.getCustomer().getUserId();
       Customer checkCustomer = customerService.showCustomer(customerId );

       if(checkCustomer!=null) {
           proposalService.save(proposal);
           return ResponseEntity.ok().body("New Proposal has been saved with ID:" + proposal.getProposalId());
       } else {
           return ResponseEntity.ok(); //change return to your liking
       }
   }