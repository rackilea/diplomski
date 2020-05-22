public View onCreateView(LayoutInflater inflater, ViewGroup container,
                         final Bundle savedInstanceState) {
    // Inflate the layout for this fragment
    View rootView = inflater.inflate(R.layout.fragment_user_list, container, false);
    btnBusquedaUserList = (Button) rootView.findViewById(R.id.btnBuscarUserList);
    rvUserList = (RecyclerView) rootView.findViewById(R.id.rvUserList);
    rvUserList.setLayoutManager(new LinearLayoutManager(getContext()));
    txtCIbusqueda = (TextInputEditText) rootView.findViewById(R.id.txtCIUserList);

    return rootView;
};

@Override
public void onStart() {

    getActivity().setTitle("Lista Usuarios Check In");
    Bundle args = getArguments();
    idUsuario = args.getString("idLogueado");
    GetClient();

    btnBusquedaUserList.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            ciUser = txtCIbusqueda.getText().toString();
            Object lista[] = new Object[2];
            lista[0] = ciUser;
            lista[1] = idUsuario;
            parametroApi.setDatoG(lista);
            GetClient();

        }
    });
}