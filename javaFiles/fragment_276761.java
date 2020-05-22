String simpleTeamTemplate = "<teams:{ team |<team.name> has <length(team.players)> players<\\n>}>";

ST template = new ST( simpleTeamTemplate );
template.add("teams", teams);

System.out.println(template.render());