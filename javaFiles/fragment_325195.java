@Override
public void onClick(View v) {
    String ET = editText.getText().toString();
    if (!ET.equals("")) {
        list.add(ET);
        dataAdapter.notifyDataSetChanged();
    }
}