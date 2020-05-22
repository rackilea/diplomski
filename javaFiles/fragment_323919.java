<%

out.println("<h1>application scope</h1>");
java.util.Enumeration e=application.getAttributeNames();
out.println("<table border='3' width='1000px'>");
while(e.hasMoreElements())
    {
        String name=(String)e.nextElement();

        Object value=application.getAttribute(name);
        if(value==null)
        {
        value="NONE";
        }
        System.out.println(name+":"+value);
        if(!name.contains("ibm") && !name.contains("myfaces")       )
        {
            if(value!=null && value.getClass().toString().contains("versata"))
            {
                out.println("<tr style='font-weight:bold;color:red;'>");        
            }
            else
            {
                out.println("<tr>");    
            }
                out.println("<td>");        
                out.println("Name: "+name);
                out.println("</td>");       
                out.println("<td>");        
                out.println("Value: "+value);
                out.println("</td>");       
                if(value!=null)
                {
                out.println("<td>");        
                out.println("Class: "+value.getClass());
                out.println("</td>");       
                }
                out.println("</tr>");       
        }
    }
out.println("</table>");
out.println("<h1>session scope</h1>");

e=session.getAttributeNames();
out.println("<table border='3' width='1000px'>");
while(e.hasMoreElements())
    {
        String name=(String)e.nextElement();

        Object value=application.getAttribute(name);
        if(value==null)
        {
        value="NONE";
        }
        System.out.println(name+":"+value);
        if(!name.contains("ibm") && !name.contains("myfaces")       )
        {
            if(value!=null && value.getClass().toString().contains("versata"))
            {
                out.println("<tr style='font-weight:bold;color:red;'>");        
            }
            else
            {
                out.println("<tr>");    
            }
                out.println("<td>");        
                out.println("Name: "+name);
                out.println("</td>");       
                out.println("<td>");        
                out.println("Value: "+value);
                out.println("</td>");       
                if(value!=null)
                {
                out.println("<td>");        
                out.println("Class: "+value.getClass());
                out.println("</td>");       
                }
                out.println("</tr>");       
        }
    }
out.println("</table>");

out.println("<h1>request scope</h1>");

e=request.getAttributeNames();
out.println("<table border='3' width='1000px'>");
while(e.hasMoreElements())
    {
        String name=(String)e.nextElement();

        Object value=application.getAttribute(name);
        if(value==null)
        {
        value="NONE";
        }
        System.out.println(name+":"+value);
        if(!name.contains("ibm") && !name.contains("myfaces")       )
        {
            if(value!=null && value.getClass().toString().contains("versata"))
            {
                out.println("<tr style='font-weight:bold;color:red;'>");        
            }
            else
            {
                out.println("<tr>");    
            }
                out.println("<td>");        
                out.println("Name: "+name);
                out.println("</td>");       
                out.println("<td>");        
                out.println("Value: "+value);
                out.println("</td>");       
                if(value!=null)
                {
                out.println("<td>");        
                out.println("Class: "+value.getClass());
                out.println("</td>");       
                }
                out.println("</tr>");       
        }
    }
out.println("</table>");

%>