boolean loggedin=false;
    if(!loggedin){
        Cookie c = new Cookie("URC", request.getPathInfo());
        c.setHttpOnly(true);
        c.setPath(request.getContextPath());
        c.setMaxAge(-1);
        response.addCookie(c);
        //forward request to login jsp page
    }else{
        Cookie cookie = getUrlRedirectCookie(request);
        if(cookie!=null){
            //redirect to cookie.getValue()
        }else{
            //execute the jsp
        }
    }
}

private Cookie getUrlRedirectCookie(HttpServletRequest request){
    Cookie[] cookies = request.getCookies();
    if(cookies!=null && cookies.length>0){
        for (int i = 0; i < cookies.length; i++) {
            Cookie cookie = cookies[i];
            if(cookie.getName().equals("URC")){
                return cookie;
            }
        }
    }
    return null;
}