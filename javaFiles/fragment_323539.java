@RequestMapping("/auth")
    public String sendToAuthorization(HttpServletRequest request) {        
    String baseUrl = String.format("%s://%s:%d/tasks/",request.getScheme(),  request.getServerName(), request.getServerPort());


        return "redirect:" +  auth.getAuthorizationUrl(baseUrl);
    }