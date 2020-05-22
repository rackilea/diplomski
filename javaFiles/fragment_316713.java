public class My_Task extends Activity {

        TextView cus_name_txt, contact_no_txt, ticket_no_txt, task_detail_txt,attend_by_txts;
        EditText attend_by_txtbx, cus_name_txtbx, contact_no_txtbx, ticket_no_txtbx, task_detail_txtbx;
        Button btnSave;
        Button btnDelete;

////YOUR CODE here

  @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.my_task);


        cus_name_txt = (TextView) findViewById(R.id.cus_name_txt);

        contact_no_txt = (TextView)findViewById(R.id.contact_no_txt);

        ticket_no_txt = (TextView)findViewById(R.id.ticket_no_txt);

        task_detail_txt = (TextView)findViewById(R.id.task_detail_txt);

        attend_by_txts = (TextView)findViewById(R.id.attend_by_txt;

        attend_by_txtbx = (EditText)findViewById(R.id.attend_by_txtbx);
        attend_by_txtbx.setText(attend_by_txt);
        //your code here