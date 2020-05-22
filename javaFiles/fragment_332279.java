public class inboxCellAdapter extends ArrayAdapter {
  inboxCellElement[] elts;
  NavDrawer navDrawer;
  Activity activity;

  // constructor
  public inboxCellAdapter(Activity activity, int resource, Object[] objects, NavDrawer navDrawer) {
      super(context, resource, objects);
      this.activity = activity;
      elts = (inboxCellElement[]) objects;
      this.navDrawer = navDrawer;
  }