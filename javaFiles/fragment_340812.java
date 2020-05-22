public class CustomFilter extends OncePerRequestFilter {
    public void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        ServletRequest copiedRequest = new HttpRequestWrapper(request);

        Map<String, Object> jsonMap = mapper.readValue(copiedRequest.getInputStream(), Map.class);

        if(jsonMap.containsKey("userId")){
            long userId = jsonMap.get("userId");
            MyClass myObject= myAutowiredService.getMyObject(userId);
            if(myObject == null){
                response.setStatus(HttpStatus.SC_NOT_ACCEPTABLE);
                //return false;
            } 
            // some more validations which end up returning false if they are met
         }

         filterChain.doFilter(copiedRequest, (ServletResponse) response);
    }
}