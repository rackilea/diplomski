public class MainActivity extends FragmentActivity implements OnClickListener {

ListView listView;
int lastIndex = -1;
ArrayList<Event> lstEvents = new ArrayList<Event>();

// detail view
TextView tvTitle, tvTime, tvDate;
ImageView ivPic;
View vw_master;

boolean _isBack = true;

ImageButton add;

String title;
String date;
String time;
int resId;

static final int PICK_CONTACT_REQUEST = 0;

@Override
public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

    // // get detail controls
    tvTitle = (TextView) findViewById(R.id.textViewTitle);
    tvDate = (TextView) findViewById(R.id.textViewDate);
    tvTime = (TextView) findViewById(R.id.textViewTime);
    ivPic = (ImageView) findViewById(R.id.imageView1);

    add = (ImageButton) findViewById(R.id.add);
    add.setOnClickListener(this);


    /////////////////////////////////LISTVIEW////////////////////////////////////////
    // Create the adapter to convert the array to views
    EventAdapter adapter = new EventAdapter(this, lstEvents);

    // attach adapter to a list view
    listView = (ListView) findViewById(R.id.listViewFragment);
    listView.setAdapter(adapter);
    /////////////////////////////////LISTVIEW////////////////////////////////////////




    // /////////////////////////////DATABASE/////////////////////////////////////////////
    DatabaseHandler db = new DatabaseHandler(this);
    // /////////////////////////////DATABASE/////////////////////////////////////////////

    List<Event> events = db.getAllContacts();

    adapter.addAll(events);
    adapter.notifyDataSetChanged();






}

@Override
public void onClick(View v) {
    // TODO Auto-generated method stub
    switch (v.getId()) {
    case R.id.add:
        Intent intent = new Intent(this, CreateActivity.class);
        startActivityForResult(intent, 100);
        break;
    }
}

@Override
public void onActivityResult(int requestCode, int resultCode, Intent data) {
    super.onActivityResult(requestCode, resultCode, data);

    // /////////////////////////////DATABASE/////////////////////////////////////////////
    DatabaseHandler db = new DatabaseHandler(this);
    // /////////////////////////////DATABASE/////////////////////////////////////////////

    // Create the adapter to convert the array to views
    EventAdapter adapter = new EventAdapter(this, lstEvents);

    // attach adapter to a list view
    listView = (ListView) findViewById(R.id.listViewFragment);
    listView.setAdapter(adapter);

    if (requestCode == 100) {
        if (resultCode == RESULT_OK) {
            Bundle b = data.getExtras();
            title = b.getString("TITLE");
            time = b.getString("TIME");
            date = b.getString("DATE");

            // retrieving bitmap from CreateActivity

            Bitmap bitmap = (Bitmap) b.getParcelable("DRAWABLE");

            // converting from bitmap to drawable
            Drawable drawable = new BitmapDrawable(getResources(), bitmap);

            // Event newEvent = new Event();
            // newEvent.set_date(date);
            // newEvent.set_title(title);
            // newEvent.set_time(time);

            // set drawable
            // newEvent.set_drawable(drawable);

            // lstEvents.add(newEvent);

            // adapter.addAll(lstEvents);
            // adapter.notifyDataSetChanged();

            ///////////////////////////////DATABASE/////////////////////////////////////////////
            /**
             * CRUD OPERATIONS
             */

            Log.e("Insert: ", "Inserting ..");
            db.addEvent(new Event(0, title, time, date, drawable));

            // Reading all contacts
            Log.e("Reading: ", "Reading all contacts..");
            // List<Event> events = db.getAllContacts();
            List<Event> events = db.getAllContacts();
            adapter.addAll(events);
            adapter.notifyDataSetChanged();

            //logging all events

            for (Event ev : events) {
                String log = "Id: " + ev.get_Id() + " ,Title: "
                        + ev.get_title() + " ,Date: " + ev.get_date();
                // Writing Contacts to log
                Log.e("Name: ", log);

            }

            ///////////////////////////////DATABASE/////////////////////////////////////////////
        }

    }
}