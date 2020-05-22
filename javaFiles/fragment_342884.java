class YourActivity extends AppCompatActivity {
  // some codes
  private void setupFragment() {
    SongsFragment fragment = new SongsFragment();
    fragment.setListener(new RecyclerViewClickListener() {
      @Override
      void onClick(int position) {
        // do something on the object clicked from rv
      }
    });
  }
}