// Create the list adapter
SimpleCursorAdapter adapter = new SimpleCursorAdapter(
        CfsApplication.getApplication(),
        R.layout.listitem_vehicledraft,
        VehicleDraftTable.getAllVehicleDrafts(),
        displayFields,
        displayViews) {
    /* (non-Javadoc)
     * @see android.widget.CursorAdapter#getView(int, android.view.View, android.view.ViewGroup)
     */
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        // Get the view from the super function which will handle most of everthing for us
        convertView = super.getView(position, convertView, parent);

        // Set the image view here
                    // ...

        // Return the view
        return convertView;
    }
};