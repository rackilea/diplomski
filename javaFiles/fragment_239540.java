public class YourFragment extends Fragment{
   View rootView; // create your rootView in here
   @Override
   public View onCreateView(LayoutInflater inflater,
      ViewGroup container, Bundle savedInstanceState) {
      ... 
      rootView = inflater.inflate(R.layout.your_fragment, container, false);
      return rootView;
   }

   ....

   public class GetMethodEx  extends AsyncTask<String, Void, InputStream> {
        ...
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            fajrTV = (TextView) rootView.findViewById(R.id.fajr); // use the rootView
            zuhrTV = (TextView) rootView.findViewById(R.id.zuhr);
            asrTV = (TextView)  rootView.findViewById(R.id.asr);
            maghribTV = (TextView) rootView.findViewById(R.id.maghrib);
            ishaTV = (TextView) rootView.findViewById(R.id.isha);
        }
    }
    ...
}