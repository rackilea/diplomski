public class DummyActivity extends Activity
{
  protected void onCreate(Bundle savedInstanceState)
  {
    super.onCreate(savedInstanceState);
    finish();
  }

  public static void Launch(Activity activity)
  {
    Intent myIntent = new Intent(activity, DummyActivity.class);
    activity.startActivity(myIntent);
  }
}