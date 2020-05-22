if (error.equals(""))
{
    System.out.print(receptnr);
   if(error1.equals(""))
     {
        System.out.print(varenr);
        response.sendRedirect("VisOKData.jsp?varenr_resultat="+varenr);
     }
   else
    {
       response.sendRedirect("VisError.jsp?error_resultat="+error);
    }
}
else
 {
     response.sendRedirect("VisError.jsp?error_resultat="+error);
 }