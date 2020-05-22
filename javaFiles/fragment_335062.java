@Override
public void onActivityCreated(Bundle savedInstanceState) {

 GridView gridView = (GridView) getView().findViewById(R.id.photos);

    // Instance of ImageAdapter Class
    gridView.setAdapter(new ImageAdapter(getActivity()));
    gridView.setOnItemClickListener(new OnItemClickListener() {
        @Override
        public void onItemClick(AdapterView<?> parent, View v,
                                int position, long id) {

            // Sending image id to FullScreenActivity
            Intent i = new Intent(getActivity(), FullImageActivity.class);
            // passing array index
            i.putExtra("id", position);
            startActivity(i);
        }
    });
   }