TeamMember member = new TeamMember()...

EM.getTransactio().beging(); //if manage transactions manually
Team team = EM.find(Team.class,id);
team.getTeamMembers().add(member);
EM.getTransaction().commit();