String teamName;
String[] members = new String[4];

public String getTeamName()
{
    return teamName;
}
public void setTeamName(String team)
{
    // Here you need to assign the team to teamName, not "team"
    teamName = team;
}



public void setMember(int number, String name)
{
    members[number] = name;
}

public String getMember(int number)
{
    return members[number];
}

public static void main(String[] args)
{

}