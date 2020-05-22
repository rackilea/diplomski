@RequestMapping(produces="application/json", value = "/usersQuery", method=RequestMethod.GET)
    public @ResponseBody PagedResources<Resource<UserDetails>> listItemsSortQuery(@PageableDefault(size = 20, page = 0) Pageable pageable, PagedResourcesAssembler<UserDetails> assembler, 
  @RequestParam("filter")String filter, @RequestParam("value")String value) {


        Page<UserDetails> lstUserDetails = userDetailsRepository.findByFilter(pageable, filter, value);

        return assembler.toResource(lstUserDetails);
    }