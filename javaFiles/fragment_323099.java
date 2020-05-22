@RequestMapping(value="/testStart", method=RequestMethod.POST)
public String testStart(HttpServletRequest request, HttpServletResponse response){
    String token = "126712810-1289291";

    request.setAttribute("authToken", token);

    return "forward:/test";
}

@RequestMapping(value="/test", method={ RequestMethod.POST, RequestMethod.GET })
public String getTestPage(Model model, HttpServletRequest request, HttpServletResponse response)
{   

    //-----------------
    //resolving token
    String token = null;
    DispatcherType type = request.getDispatcherType();

    if(type == DispatcherType.FORWARD)
    {
        token = (String) request.getAttribute("authToken");
    }
    else if(type == DispatcherType.REQUEST)
    {
        token = (String) request.getHeader("authToken");
    }
    //-----------------

    System.out.println(token);  //prints the value
    model.addAttribute("Testtoken", token);
    System.out.println("Test page about to load ..");
    return "test";
}