public class EmployeeListActivity extends AppCompatActivity implements EmployeeContract.View {

private static final String TAG = EmployeeListActivity.class.getSimpleName();
private ListView listView;
private EmployeeContract.GetPresenter presenter;

@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_employee_list);

    presenter = new EmployeePresenter(this);
}

@Override
public void initView(List<Employee> employees, Presenter.Callback callback) {
    listView = findViewById(R.id.listview);
    EmployeesAdapter adapter = new EmployeesAdapter(this, employees);
    listView.setAdapter(adapter);

    listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            callback.onClick(position);
        }
    })
}

@Override
protected void onResume() {
    super.onResume();
    //presenter = new EmployeePresenter(this);
}