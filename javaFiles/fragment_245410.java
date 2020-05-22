class User {
  List<Team> teams...

  public String toString() {
    StringBuilder sb = ...
    sb.append("a user and ");

    for (Team team : teams) {
      sb.append("[a team with id ")
      sb.append(team.getId());
      sb.append("and team name ");
      sb.append(team.getName());
      sb.append("] ");
    } 
    return sb.toString();
  }
}