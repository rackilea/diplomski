while(true)
{
    line = br.readLine();
    System.out.println("Received string: "+line+" from connection "+id);

    if(line.equals("exit"))
    {
        break; //just stop this connection, don't kill server
    }
    else if(line.equals("stop"))
    {
        stopserver = true; //stop server too
        break;
    }
    else
    {
        int len = line.length();
        for (int i=len-1; i>=0; i--) {
            reversedstring = reversedstring + line.charAt(i);
        }
        ps.println(""+reversedstring);
    }
}