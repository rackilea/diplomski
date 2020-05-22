public class YourAdapter extends ArrayAdapter<String> {
  private final Context context;
  // blahblahblah
  private final TextView mYourTextView;

 public YourAdapter(Context context, String[] values, TextView btnUpdate) {
     super(context, R.layout.rowlayout, values);
     this.context = context;
     this.values = values;
     mYourTextView = btnUpdate;
 }

 ....

 @Override
    public void onClick(View v) {
        Toast.makeText(_c, "clicked quick add "+p, Toast.LENGTH_SHORT).show();
        //mYourTextView.setTag(1);
        //mYourTextView.setText(btnUpdate.getTag().toString());
        mYourTextView.setText("b");
    }