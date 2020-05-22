public class DonorListAdapter extends BaseAdapter
{

    private Context context;
    private int layout;
    private ArrayList<Donor> donorList;

    public DonorListAdapter(Context context, int layout, ArrayList<Donor> donorList) {
        this.context = context;
        this.layout = layout;
        this.donorList = donorList;
    }

    @Override
    public int getCount() {
        return donorList.size();
    }

    @Override
    public Object getItem(int position) {
        return donorList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    private class ViewHolder {
        TextView txtname, txtnumber, txtblood;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View row = convertView;
        if (row == null) {
            ViewHolder holder = new ViewHolder();
            row = LayoutInflater.from(context).inflate(layout, null);
            holder.txtname = (TextView)row.findViewById(R.id.contact_name);
            holder.txtnumber = (TextView)row.findViewById(R.id.contact_number);
            holder.txtblood = (TextView) row.findViewById(R.id.contact_blood);
            row.setTag(holder);
        }

        ViewHolder viewHolder = (ViewHolder) row.getTag();
        Donor donor = donorList.get(position);

        viewHolder.txtname.setText(donor.getName());
        viewHolder.txtnumber.setText(donor.getNumber());
        viewHolder.txtblood.setText(donor.getBlood());
        return row;
    }
}