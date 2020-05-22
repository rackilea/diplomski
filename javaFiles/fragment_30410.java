@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    Client client = new Client(this);
    try {
        client.connect("192.168.1.10",5555);
    } catch (IOException e) {
        e.printStackTrace();
    }
}