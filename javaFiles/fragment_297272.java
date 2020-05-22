public class PlayerTableModel extends AbstractTableModel {
  private final List<User> users;
  private final List<PlayerSummary.Player> summaries;

  public PlayerTableModel(List<User> users, List<PlayerSummary.Player> summaries) {
    this.users = new ArrayList<User>(users);
    this.summaries = new ArrayList<PlayerSummary.Player>(summaries);
  }
}