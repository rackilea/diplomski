String s="";
    Process p = Runtime.getRuntime().exec("p4 login");     
    BufferedReader in = new BufferedReader(new InputStreamReader(p.getInputStream()));    
    char a=(char)in.read();
    while(a>0 && a<256)
    {

        a=(char)in.read();
        if(nb==14) new PrintWriter(p.getOutputStream(),true).println(password); 
        if(nb>16) s=s+a;
        nb++;
    }
    if(s.startsWith("User")) loggedIn=true;
    else loggedIn=false;