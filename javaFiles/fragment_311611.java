@Override
 public void onCreate(Bundle savedInstanceState) {
       super.onCreate(savedInstanceState);
       loadvars();
  }

@Override
protected void onDestroy() {
      super.onDestroy();
      savevars();
}