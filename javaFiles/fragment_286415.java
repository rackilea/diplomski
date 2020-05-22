@Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.recycle_viewdatabase);
        Controller controller = new Controller(this);
        controller.getData();
    }