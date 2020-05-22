TextView tvPregunta;

public View onCreateView(LayoutInflater inflater, ViewGroup container,
               Bundle savedInstanceState) {
    View rootView = inflater.inflate(R.layout.joc_fragment, container, false);
    ...

    tvPregunta = (TextView) rootView.findViewById(R.id.tvPregunta); // instantiate here
    berijuego=(ImageButton)rootView.findViewById(R.id.ibBeriJuego);

    ...

    return rootView;
}

public void seguentelement() {
    switch (nivellactual) {
        case 1:
            // 
            String pregunta = ("Quin element és el Hidrògen?");
            tvPregunta.setText(pregunta);
            // int de elemento es la imagebutton
            elementcorrecte = (R.id.ibHidroJuego);
            break;
    }
    ...
}