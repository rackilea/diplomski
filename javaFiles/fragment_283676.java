@Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_fullscreen_dialog, container, false);
        ImageButton close = view.findViewById(R.id.fullscreen_dialog_close);
        TextView action = view.findViewById(R.id.fullscreen_dialog_action);

        titleEdit = view.findViewById(R.id.fullscreen_dialog_title);
        infoEdit = view.findViewById(R.id.fullscreen_dialog_info);
        fullEdit = view.findViewById(R.id.fullscreen_dialog_full);


        close.setOnClickListener(this);
        action.setOnClickListener(this);

        return view;
    }