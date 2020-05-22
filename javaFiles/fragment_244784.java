@RequestMapping(value = Constants.URL, method = RequestMethod.GET)
public @ResponseBody ListHolder getFoos(HttpServletResponse response) {
    response.setContentType("application/xml");         
    List<Foo> foos = getFoos(); 
    ListHolder listHolder = new ListHolder();
    listHolder.setFoos(foos);
    return listHolder;
}