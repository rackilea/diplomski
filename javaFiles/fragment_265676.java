public class Username {

    private HttpSession session;

    Username(HttpSession session){
       this.session = session;
    }

    public String getUserName(Long userId) {

        /* remove the following line */
       //HttpSession session1 = request.getSession(false);// error is coming here for request

       String userid = (String)session.getAttribute("userid");

       // i want to fetch user name from database by the userid above 

       String userName = "";
       //all my sql code here
        return userName;
   }

}