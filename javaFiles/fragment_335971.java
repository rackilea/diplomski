public class MyServletContainer extends com.sun.jersey.spi.container.servlet.ServletContainer{

    @override
    public void doFilter(javax.servlet.http.HttpServletRequest request,
                 javax.servlet.http.HttpServletResponse response,
                 javax.servlet.FilterChain chain)
          throws java.io.IOException,
                 javax.servlet.ServletException {

                //get param from request
                //connect to DB or any cache system to validate the param value

                //if validation fail: do something like this [NOT TESTED NEED SOME TRY and ERROR...]
                if(!dataSrc.isValidUser(paramValue)){
                    PrintWriter out= response.getWriter();
                    out.println("{"status":"fail","message":"invalie user info"}");
                    out.flush();//maybe ...
                }else {
                    //validation is OK, so keep doing what original ServletContainer (super) should do
                    super.doFilter(request, response, chain);
                 }
    }//doFilter() --end

}//CLASS