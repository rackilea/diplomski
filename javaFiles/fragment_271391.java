<% Student_fetch  namesDAO = new Student_fetch ();
 Set<Student> all_names = namesDAO.getDetails(); 
   for( Students s1  :all_names) {  
    out.println(s1.getStud_name());
    out.println(s1.getStud_subject());
    out.println(s1.getStud_code());
   }
%>