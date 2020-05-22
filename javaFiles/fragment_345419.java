String msgName=request.getParameter("msgName");
boolean insideIf=false; 

if(msgName.substring(0,1).equals("1"))
    {
        insideIf=true;
                System.out.println("if status :"+msgName.substring(0,1).equals("1"));

    } System.out.println("insideIf :"+insideIf);