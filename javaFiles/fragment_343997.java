@Override
protected void onPrepareDialogBuilder(android.app.AlertDialog.Builder builder) {
    LayoutInflater inflater = (LayoutInflater)context.getSystemService (Context.LAYOUT_INFLATER_SERVICE);
    builder.setTitle(R.string.set_radius_dialog_fragment_title);
    View v = inflater.inflate(R.layout.dialog_radius_picker, null);
    builder.setView(v);
    builder.setPositiveButton(android.R.string.ok, null);
    builder.setNegativeButton(android.R.string.cancel, null);
}