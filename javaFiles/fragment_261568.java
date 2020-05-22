private TextView tvInfo = null;
private Button btnInfo = null;
@Override
public void onCreate(Bundle savedInstanceState) 
{
    super.onCreate(savedInstanceState);
    setContentView(R.layout.configuration);
            tvInfo = (TextView)findViewById(R.id.tvInfo);
            btnInfo = (Button)findViewById(R.id.btnInfo);
            ........
    }