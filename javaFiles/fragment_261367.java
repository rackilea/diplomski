public class IconArrayAdapter<T extends IconListItem> extends ArrayAdapter<T> {
  protected int resource;
  public IconArrayAdapter(Context context, int resource, ArrayList<T> items) {
      super(context, resource, items);
      this.resource = resource;
  }
}

public class TeamListArrayAdapter extends IconArrayAdapter<TeamListItem> {
  public TeamListArrayAdapter(Context context, ArrayList<TeamListItem> items) {
      super(context, R.layout.team_list_item, items);
  }
}