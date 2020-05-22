@Override
public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    View v= inflater.inflate(R.layout.tab_fragment_2, container, false);

    frecuencia = (EditText) v.findViewById(R.id.frecuencia);
    cal3el = (Button) v.findViewById(R.id.calcular3);
    ...
}