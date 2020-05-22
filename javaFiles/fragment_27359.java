Context cont;
DataSource ds;
Double lon = 0.0;
Double lat = 0.0;
RecycleAdoptor(Context paramContext)
{
    this.cont = paramContext;
}
private List<Employee> mDocs;

@Override
public RecycleAdoptor.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
    Log.e("jarvis", "RecylerAdoptor");
    LayoutInflater inflater = LayoutInflater.from(parent.getContext());
    View v = inflater.inflate(R.layout.activity_list_items, parent, false);
    // set the view's size, margins, paddings and layout parameters
    ViewHolder vh = new ViewHolder(v);
    return vh;

}

public RecycleAdoptor(List<Employee> myDataset, Context context) {
    mDocs = myDataset;

}

@Override
public void onBindViewHolder(ViewHolder holder, final int position) {
    // - get element from your dataset at this position
    // - replace the contents of the view with that element

    final Employee emp = mDocs.get(position);

    holder.empID.setText(emp.getID());
    holder.empName.setText(emp.getEmpName());
    holder.empDesignation.setText(emp.getDesignation());
    holder.empSpeciality.setText(emp.getSpeciality());
    holder.empAddress.setText(emp.getAddress());

}
@Override
public int getItemCount() {
    return mDocs.size();
}

public class ViewHolder extends RecyclerView.ViewHolder {
    // each data item is just a string in this case
    public TextView empID;
    public TextView docID;
    public TextView empName;
    public TextView empAddress;
    public TextView empDesignation;
    public TextView empSpeciality;
    public TextView empStatus;
    public Button btnSaveAttd;
    public Spinner spinner;
    public View layout;

    public ViewHolder(View v) {
        super(v);
        layout = v;
        empID = (TextView) v.findViewById(R.id.emp_id);
        empName = (TextView) v.findViewById(R.id.empName);
        empDesignation = (TextView) v.findViewById(R.id.empDesignation);
        empSpeciality = (TextView) v.findViewById(R.id.empSpecialist);
        empAddress = (TextView) v.findViewById(R.id.empAddress);
        spinner = (Spinner) v.findViewById(R.id.spinner1);
        btnSaveAttd = (Button) v.findViewById(R.id.btnSaveAttd);

        btnSaveAttd.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Date currentTime = Calendar.getInstance().getTime();
                double lon = ProfileActivity.Lon;
                double lat = ProfileActivity.Lat;

                AlertDialog.Builder alertDialog = new AlertDialog.Builder(v.getContext());//Here I have to use v.getContext() istead of just cont. 
                alertDialog.setTitle("Leave application?");
                alertDialog.setMessage("Are you sure you want to leave the application?");
                alertDialog.setIcon(R.drawable.ic_menu_camera);
                alertDialog.setPositiveButton("YES",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {

                            }
                        });
                alertDialog.setNegativeButton("NO",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {

                            }
                        });
                alertDialog.show();

           }
        });

    }
}