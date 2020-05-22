public class NewOrderActivity
extends Activity{


@Override
protected void onCreate(Bundle savedInstanceState)
{
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_new_order);
TextView info = (TextView)findViewById(R.id.crew_id_and_ordertype);
    info.setText("Crew ID: " + CrewIDActivity.crew_id + "/n /n" + OrderingActivity.orderType);
}