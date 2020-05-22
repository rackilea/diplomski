@RequestMapping(value = "/server-B", method = RequestMethod.GET)
public String test(HttpServletRequest request) {

        System.out.println(request.getRemoteAddr()); // here will be server A IP address
        return "Success";
    }