@RequestMapping(method = RequestMethod.GET)
   public Page<Inscription> findAll(
       final @RequestParam(defaultValue = "0", required = false) int offset,
       final @RequestParam(defaultValue = "20", required = false) int limit,
       final @RequestParam(required = false) String[] status
   )
   {
       Specification<Inscription> specStatusNameIn = InscriptionSpecification.statusNameIn(status);
       inscriptionRepository.findAll(specStatusNameIn, new PageRequest(offset, limit));
       return inscriptions;
   }
}