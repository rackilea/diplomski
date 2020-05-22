class CustomAdapter extends ArrayAdapter<SimpleObject> {


    public CustomAdapter(Context context, ArrayList<SimpleObject> objectList) {
        super(context,R.layout.custom_row ,objectList);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater jobsiteInflater = LayoutInflater.from(getContext());
        View customView = jobsiteInflater.inflate(R.layout.custom_row, parent, false);

        // Get the SimpleObject
        SimpleObject item = (SimpleObject) getItem(position);
        String singleJobsiteItem = item.getJobSite(); // get the String

        ImageView josbiteImage = (ImageView) customView.findViewById(R.id.josbiteImage);

        josbiteImage.setImageResource(item.getImageID()); // get the image ID and assign it to jobsiteImage :)


        return customView;

    }
}