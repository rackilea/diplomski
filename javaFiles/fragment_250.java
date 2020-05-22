private final MyResourceAssembler myResourceAssembler;

public MyController(MyResourceAssembler myResourceAssembler) {
   this.myResourceAssembler = myResourceAssembler;
}

public HttpEntity<PagedResources<Party>> search(@RequestBody PartySearchRequest request,
                                                Pageable pageable, PagedResourcesAssembler<Party> assembler ) {

    Map<String,String> searchFilters = RequestValidator.validateContractSearchFilters(request);

    Page<Party> parties = repository.findByFirstNameOrLastName(searchFilters.get("firstName"), searchFilters.get("lastName"), pageable);

    Link selfLink = linkTo(methodOn(this.getClass().view(pageable, null)).withSelfRel();

    return new ResponseEntity(assembler.toResource(parties, myResourceAssembler, selfLink), HttpStatus.OK);

}