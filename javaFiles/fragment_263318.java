@WebServlet("/updateInvestorAcc")
public class UpdateInvestorAcc extends HttpServlet {

 public void doGet(HttpServletRequest request,
    HttpServletResponse response)
    throws ServletException, IOException {

     String idStr=request.getParameter("id");
     int id= Integer.parseInt(idStr);// If you need to parse to int
     String[] chkSms=request.getParameterValues("chkSms");
     boolean isChkSms =false;
     if(chkSms !=null && chkSms.length > 0){//If checkbox is checked than assign it with true or 1       
         isChkSms=true;  
     }

    // Now update the DB with id and checkbox value.
 }