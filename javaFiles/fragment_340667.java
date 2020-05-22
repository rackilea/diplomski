@Override
public View onCreateView(LayoutInflater inflater, ViewGroup container, 
Bundle savedInstanceState) {
   ...
   profileImage.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View view) {
        Intent settingsClick = new Intent(getActivity(), 
        ProfileSettingsActivity.class);
        startActivityForResult(settingsClick,0);
      }
   });

   ...

   return view;
}