public class FaltasActivity extends AppCompatActivity implements OnFaltasReturn, OnAlumnoReturn, OnHorarioReturn {

private TextView nombre, apellidos, correo, titleFault;

private Toolbar toolbar;

private RecyclerView mRecyclerView;
private RecyclerView.LayoutManager mLayoutManager;

private ArrayList<Falta> listaFaltas;
private ArrayList<Horario> listaHorario;
private List<String> list;
private FaltasAdapter adapter;
private ArrayAdapter<String> spinnerAdapter;

private Integer idModulo, idAlumno, idHorario;
private Button falta;
private Spinner spinner;

@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_faltas);

    toolbar = findViewById(R.id.toolbar_faltas);
    titleFault = findViewById(R.id.toolbar_title_fault);
    titleFault.setText("Faltas");
    setSupportActionBar(toolbar);


    // SPINNER I think the spinner is well implemented ... but I can not add the objects to the lists correctly.
    spinner = findViewById(R.id.spinner);

    listaHorario = new ArrayList<>();
    list = new ArrayList<>();

    HorarioATask horarioATask = new HorarioATask(this, this);
    horarioATask.execute();


    //Finish SPINNER code

    idModulo = getIntent().getExtras().getInt("ID_MODULO");
    idAlumno = getIntent().getExtras().getInt("ID_ALUMNO");
    idHorario = 1;  //This is the variable to be replaced when a start is selected.

    nombre = findViewById(R.id.item_tittle);
    apellidos = findViewById(R.id.second_item);
    correo = findViewById(R.id.third_item);

    mRecyclerView = findViewById(R.id.rvf);

    AlumnoATask alumnoATask = new AlumnoATask(this, this, idAlumno);
    alumnoATask.execute();

    listaHorario = new ArrayList<>();

    falta = findViewById(R.id.action_button_1);
    falta.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            AsyncTask.execute(new Runnable() {
                @Override
                public void run() {
                    Gson gson = new Gson();
                    final ApiConnector apiConnector = new ApiConnector();
                    final String URI_POST = "faltas";
                    String token;

                    String uri = URI_POST;
                    String method = "POST";
                    String json;

                    Alumno alumno = new Alumno(idAlumno);
                    Modulo modulo = new Modulo(idModulo);
                    Horario horario = new Horario(idHorario);

                    Falta falta = new Falta(alumno, horario, modulo);

                    json = gson.toJson(falta, Falta.class);

                    SharedPreferences prefs = getSharedPreferences("userObject", Context.MODE_PRIVATE);
                    token = prefs.getString("token", "");

                    apiConnector.consult(uri, method, json, token);

                }
            });
        }
    });

    listaFaltas = new ArrayList<>();

    mLayoutManager = new LinearLayoutManager(this);
    mRecyclerView.setHasFixedSize(true);
    adapter = new FaltasAdapter(this, listaFaltas);
    mRecyclerView.setAdapter(adapter);
    mRecyclerView.setLayoutManager(mLayoutManager);

    FaltaATask faltaATask = new FaltaATask(this, this, idAlumno, idModulo);
    faltaATask.execute();

}

@Override
public void onFaltasConsultados(ArrayList<Falta> listaFaltas) {
    this.listaFaltas.clear();
    this.listaFaltas.addAll(listaFaltas);
    this.adapter.notifyDataSetChanged();

     for (int i = 0; i < listaHorario.size(); i++) {
        list.add(listaHorario.get(i).getInicio());
    }

    spinnerAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, list);
    spinnerAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

    spinner.setAdapter(spinnerAdapter);

}

@Override
public void onFaltasError() {
    Toast.makeText(this, "Error en el listado de faltas", Toast.LENGTH_SHORT).show();
}

@Override
public void onAlumnosConsultados(Alumno alumno) {
    this.nombre.setText(alumno.getNombre());
    this.apellidos.setText(alumno.getApellidos());
    this.correo.setText(alumno.getCorreo());
}

@Override
public void onAlumnosError() {
    Toast.makeText(this, "Error en los datos del alumno", Toast.LENGTH_SHORT).show();
}

//In theory this fills the lists (Interface)
@Override
public void onHorarioConsultados(ArrayList<Horario> listaHorario) {
    this.listaHorario.clear();
    this.listaHorario.addAll(listaHorario);
    this.adapter.notifyDataSetChanged();
}

@Override
public void onHorarioError() {
    Toast.makeText(this, "Error con los horarios", Toast.LENGTH_SHORT).show();
}

}