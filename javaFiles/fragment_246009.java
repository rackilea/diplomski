...
 else if(request.getParameter("partnerID")!=null) {
            try{
                tenantId = Integer.parseInt(request.getParameter("partnerID"));
            }catch(Exception e)
            {}
        }
...
return tenantId