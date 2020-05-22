public class TeamResultHandler implements ResultHandler {

  private List<Team> teams = new CopyOnWriteArrayList<Team>();

  @Override
  public void handleResult(ResultContext rc) {
    countries.add((Team) rc.getResultObject());
  }

  // provide a getter so you can retrieve it when finished
  public List<Team> getTeamList() {
    return teams;
  }
}