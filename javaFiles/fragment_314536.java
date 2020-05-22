<% 
     ProcessFile processFile=(ProcessFile)application.getAttribute("processFile");
     if(null==processFile){
     // make sure that all method of this class is synchronized beacause of multiple users
         processFile=new  ProcessFile("pathToOpenFile");
     }

     application.setAttribute("processFile", processFile); 
     //now processFile available globally. 
    %>