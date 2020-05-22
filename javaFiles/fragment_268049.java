private SocketViewModel socketModel;

@Override public void onCreate(Bundle savedInstance) {
     super.onCreate(savedInstance);
     ... your view init ...

     socketModel = ViewModelProviders.of(this).get(SocketViewModel.class);
}