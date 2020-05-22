DBManager dbManager = new DBManager(getActivity());
dbManager.open();

Cursor cursor = dbManager.fetch();
cursor.moveToFirst();
final TextView studentName = (TextView) getActivity().findViewById(R.id.nameOfStudent);
studentName.settext(cursor.getString(0));