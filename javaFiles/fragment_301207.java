@RequestMapping(path="/getkey/{company_id}", method = RequestMethod.GET)
    String getKey(@PathVariable int company_id) {
    String encKey = null;

    gkrepo.findOneByCompanyId(company_id);

    return encKey; //YOU RETURN NULL HERE
}