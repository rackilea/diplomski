connection = (ImageView) findViewById(R.id.image_view);
        note = (TextView) findViewById(R.id.err);
        cd = new ConnectionDetector(getApplicationContext());
        // get Internet status
        isInternetPresent = cd.isConnectingToInternet();

    if (!isInternetPresent) {
        hidePDialog();
        connection.setVisibility(View.VISIBLE);
        note.setVisibility(View.VISIBLE);
    } else {
             connection.setVisibility(View.INVISIBLE);
            note.setVisibility(View.INVISIBLE);

             **Do What U want here**

}