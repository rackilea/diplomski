@RequestMapping(value = "/new", method = RequestMethod.GET)
public @ResponseBody ResponseEntity getNewLeadsDetails(Pageable pageable, Authentication authentication,
    HttpServletRequest httpServletRequest) { 
  if(null == pageable) {
      return leadService.getNewLeads(authentication);
  } else {
      return leadService.getNewLeads(pageable.getPageNumber(),pageable.getSize(),authentication);
  }
}