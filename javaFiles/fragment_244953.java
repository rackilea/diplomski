@Override
public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
    ...
    switch (position){
        case 0:
            selectedArray = getResources().getStringArray(R.array.Wheat);
            break;
        case 1:
            selectedArray = getResources().getStringArray(R.array.Crustaceans);
            break;
        case 2:
            selectedArray = getResources().getStringArray(R.array.Eggs);
            break;
    }
}