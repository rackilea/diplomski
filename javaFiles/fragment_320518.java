@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView lv = findViewById(R.id.lv);

        List<Animal> animals = new ArrayList<>();
        for (int i = 0;i < 15; i++){
            ///addd your animals like:
            Animal rabbit = new Animal("rabbit",2,1,15);
            animals.add(rabbit)
          }


        lv.setLayoutManager(new LinearLayoutManager(this));

        lv.setAdapter(new AnimalAdapter(animals));

    }