public class ContactsAdapter extends BaseAdapter
{
    private Context context;
    private ArrayList<Contact> contacts;
    SparseBooleanArray sba=new SparseBooleanArray();

    public ContactsAdapter(Context context, ArrayList<Contact> contacts)
    {
        this.context = context;
        this.contacts = contacts;
    }

    public View getView(final int position, View convertView, ViewGroup parent) {

        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        final ViewHolder mHolder;

        if (convertView == null)
        {
            convertView = inflater.inflate(R.layout.contact, null);
            mHolder = new ViewHolder();

            mHolder.textName     =(TextView) convertView.findViewById(R.id.name);
            mHolder.textMobile   =(TextView) convertView.findViewById(R.id.mobile);
            mHolder.textSelector =(CheckBox) convertView.findViewById(R.id.selected); 

            convertView.setTag(mHolder);   

            } 
        else
        {
            mHolder = (ViewHolder) convertView.getTag();
        }

        mHolder.textMobile.setText(contacts.get(position).getMobile());
        mHolder.textName.setText(contacts.get(position).getName());
        mHolder.textName.setSelected(true);
        mHolder.textSelector.setChecked(sba.get(position));

        mHolder.textSelector.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v) {

                 if(mHolder.textSelector.isChecked())
                 {
                     sba.put(position, true);
                 }

                else
                {
                    sba.put(position, false);
                }

            }
        });

        return convertView;
    }

    private class ViewHolder 
{
        private TextView textMobile,textName;
        private CheckBox textSelector;


    }

    @Override
    public int getCount() {
        return contacts.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

}