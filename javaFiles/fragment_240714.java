@Override
public void onClick(DialogInterface dialog, int which) {
      ArrayAdapter adapter = (ArrayAdapter ) listView.getAdapter();
      String item = (String) listView.getSelectedItem();
      item += "YourText";

     adapter.insert(item, position);
}