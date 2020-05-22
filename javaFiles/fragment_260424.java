public class EmployeeFragment extends Fragment {

EmployeeDatabaseHelper dbHelper;
ListView employeeList;
public Cursor employees;
private ArrayList<Employee> arrlst;
private myadapter myadapter;

@Override
public View onCreateView(LayoutInflater inflater, ViewGroup container,
        Bundle savedInstanceState) {

    View rootView = inflater.inflate(R.layout.fragment_employee, container, false);

    employeeList = (ListView) rootView.findViewById(R.id.employeeList);
    return rootView;
}

@Override
public void onActivityCreated(Bundle savedInstanceState) {
    super.onActivityCreated(savedInstanceState);

    populateEmployeeList();
}

public void populateEmployeeList(){

    dbHelper=new EmployeeDatabaseHelper(getActivity());
     arrlst = dbHelper.getAllEmployee();
    myadapter = new myadapter(getActivity());
    employeeList.setAdapter(myadapter);

}

class myadapter extends ArrayAdapter<Employee>{
Activity con;
private LayoutInflater Inflater;

public myadapter(Activity context) {
    super(context,R.layout.row);
    con=context;
     Inflater = (LayoutInflater)con.getSystemService(con.LAYOUT_INFLATER_SERVICE);
}

class ViewHolder{
    TextView tvid;
    TextView tvname;
}

@Override
public View getView(int position, View convertView, ViewGroup parent) {
    // TODO Auto-generated method stub
    View vi = convertView;
     ViewHolder vh;
    if(vi==null){
        vh = new ViewHolder();
        vi= Inflater.inflate(R.layout.row, null);
        vh.tvid=(TextView)vi.findViewById(R.id.mainTextView);

        vh.tvname=(TextView)vi.findViewById(R.id.subTextView);
        vi.setTag(vh);

    }else{
        vh=(ViewHolder)vi.getTag();
    }
    Employee e =arrlst.get(position);
    vh.tvid.setText(e.name);
    vh.tvname.setText(e.username);
    return vi;
}
@Override
public int getCount() {
    // TODO Auto-generated method stub
    return arrlst.size();
}
}
}