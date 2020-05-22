public class AddAction implements Action {
    public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {

         //get request parameters here..

         try {
               //perform add action which throws exception..
               return "success";
         }catch(DatabaseException e) {
               request.setAttribute("errorMessage", e.getMessage());// to show exception msg in jsp.
              //log exception to console or file here..
              return "failure";
         }
    }
}