public class MainActivity extends Activity implements OnClickListener {

  @Override
  public void onCreateContextMenu (ContextMenu menu, View v, ContextMenuInfo menuInfo) {
    super.onCreateContextMenu(menu, v, menuInfo);
    MenuInflater inflater = getMenuInflater();
    inflater.inflate(R.menu.context_menu, menu);
  }

  @Override
  public void onCreate(Bundle savedInstanceState) {
    //implementation
  }
  //rest of code
}