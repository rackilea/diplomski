@Override
public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
    String clicktemplate = arrayListplayer.get(i).getTitle1();

    Intent intent = new Intent(ContactsSelect.this, PlanSMS.class);
    intent.putExtra("key_clicktemplate1", clicktemplate);
    startActivityForResult(intent,1933);
}