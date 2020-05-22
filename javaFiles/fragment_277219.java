ParseQuery<ParseObject> query = ParseQuery.getQuery("TestItem");
query.findInBackground(new FindCallback<ParseObject>() {
    public void done(List<ParseObject> objects, ParseException e) {

        if (e == null) {
            int size = objects.size();

            String[] names =  new String[size];
            String[] ids =  new String[size];

            for (int i = 0; i < size; i++) {
                ParseObject elem = objects.get(i);
                names[i] = elem.getString("name");
                ids[i] = elem.getObjectId();
            }

            /*The following code is fairly irrelevant(I think?) since the error appears
            to be somewhere in the previous lines.*/
            Bundle params = new Bundle();
            params.putStringArray("names", names);
            params.putStringArray("ids", ids);

            ft = getSupportFragmentManager().beginTransaction();

            screen = new Feed();
            screen.setArguments(params);

            ft.add(R.id.holder_frame, screen);
            ft.commit();
        } else {
            Toast.make(<Current>Activity.this, "Error", ...).show();
        }
    }
});