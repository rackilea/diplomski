@Override
public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
    ...
    Intent intent = new Intent(getApplicationContext(), InformationActivity.class);
    switch (position){
        case 0:
            String[] wheat = getResources().getStringArray(R.array.Wheat);
            intent.putExtra("Profile", wheat);
            break;
        case 1:
            String[] crus = getResources().getStringArray(R.array.Crustaceans);
            intent.putExtra("Profile", crus);
            break;
        case 2:
            String[] eggs = getResources().getStringArray(R.array.Eggs);
            intent.putExtra("Profile", eggs);
            break;
    }
}