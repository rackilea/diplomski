public String getTeam()
{           
    String x = "";  

    for(Team tm : allTeams.values())
    {           
        if(tm.getStatus().equals("Added"))
        {                   
            x = x + tm.toString();  
        }    
    }
    if (x.isEmpty())
    {
        x = "there are no teams in your league";
    }
    return x;     
}