public MyRequestMatcher implements RequestMatcher {

    boolean matches(HttpServletRequest request){
         //Define the matching logic here....
         if(request.getHeader("xxx") != null &&
            request.getHeader("xxx").equals("yyyy"){
             return true;
         }
         //blablablab
    }
}