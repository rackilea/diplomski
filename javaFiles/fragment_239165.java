public class MyAdapter extends ArrayAdapter<String>
{
  private List<String> listString = new ArrayList<String>();

  public MyAdapter(Context context, int textViewResourceId,
                        List<String> objects) {
  super(context, textViewResourceId, objects);
  // TODO Auto-generated constructor stub
  listString  = objects;
  }

  public View getCustomView(int position, View convertView, ViewGroup parent) {

   LayoutInflater inflater=getLayoutInflater();
   View row=inflater.inflate(R.layout.spinner, parent, false);
   TextView label=(TextView)row.findViewById(R.id.textView1);
   label.setText(listString.get(position)); // How to use listString
   .
   .
   .