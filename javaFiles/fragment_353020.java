protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_list);
    if (MySingleton.files!=null)
       updateList(MySingleton.files);
}