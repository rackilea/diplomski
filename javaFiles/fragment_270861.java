public class EditActivity extends AppCompatActivity implements
    OnItemClickListener {
 ...

 @Override
 protected void onCreate(Bundle savedInstanceState) {
 ...
 ReminderListAdapter adapter = new ReminderListAdapter(this, R.layout.reminder_view, ReminderList);
 adapter.setListener(this);
 listView.setAdapter(adapter);
 ...
 }


 @Override
   public void onItemClick(final View view, final int position, final String name) {
    //Your callback
    delete_Reminder(name);
  }
}