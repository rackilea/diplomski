public class TeamMember {
    private TeamMember leader;
    private Set<TeamMember> teamMembers= new HashSet<TeamMember>();
    public Set<TeamMember> getTeamMembers(){
        return new HashSet<TeamMember>(teamMembers);
    }
    public void addTeamMember(TeamMember member){
        if(member.leader!=null){
            member.leader.removeTeamMember(member);
        }
        member.leader=this;
        teamMembers.add(member);
    }
    public void removeTeamMember(TeamMember member){
        member.leader=null;
        teamMembers.remove(member);
    }
    public TeamMember getLeader(){
        return leader;
    }
}