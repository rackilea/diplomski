public class IndividualsFragment 
  extends android.support.v4.app.ListFragment 
  implements FindCallback<ParseObject> {

    private List<ParseObject> mOrganization = new ArrayList<ParseObject>();

    @Override
    public void onViewCreated(View view, Bundle b) {
        super.onViewCreated(view, b);

        CustomAdaptor adaptor = new CustomAdaptor(getActivity(), mOrganization);
        setListAdapter(adaptor);

        // This is like calling fetchList()
        ParseQuery.getQuery("Organization").findInBackground(this);
    }

    /**
    * This is needed by implementing the callback on the class
    **/
    @Override
    public void done(List<ParseObject> scoreList, ParseException e) {
        if (e == null) {
            Log.d("score", "Retrieved " + scoreList.size() + " Organization");
            mOrganization.clear();
            mOrganization.addAll(scoreList);

            ((CustomAdaptor) getListAdapter()).notifyDataSetChanged();
        } else {
            Log.d("score", "Error: " + e.getMessage());
        }
    }
}