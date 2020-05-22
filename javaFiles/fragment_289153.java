public static class AboutMeFragment extends Fragment {

     public AboutMeFragment() {
     }

     @Override

     public View onCreateView(LayoutInflater inflater, ViewGroup container,
             Bundle savedInstanceState) {
          View rootView = inflater.inflate(R.layout.aboutme,
            container, false);
          textviewabout = (TextView)rootView.findViewById(R.id.textviewabout);
          textviewabout.setText(Html.fromHtml(getString(R.string.about_me)));
          return rootView;
     }
}