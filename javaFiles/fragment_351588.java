public class YourActivity extends Activity
{
    private EditText editText = null;
    // etc.

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_layout);

        editText = (EditText) findViewById(R.id.my_edit_text);
        // etc.
    }

    private Filter listFilter = new Filter() {
        @Override
        protected FilterResults performFiltering(CharSequence constraint)
        {
        }

        @Override
        protected void publishResults(CharSequence constraint, FilterResults results)
        {
            ArrayList<SetRows> data = (ArrayList<SetRows>) results.values;
            if (data.isEmpty()) YourActivity.this.editText.setTextColor(Color.RED);
            Toast.makeText(getContext(), myTextView.getText().toString(), 2000).show();
        }
    };
}