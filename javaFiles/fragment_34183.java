@RequestMapping(path="/MyUrl", method=RequestMethod.POST)
public ModelAndView process(WebRequest request){
    System.out.println(request.getParameter("type"));
    System.out.println(request.getParameter("data[merges][EMAIL]"));
    return new ModelAndView([YOURVIEWHERE]);
}