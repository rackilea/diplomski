@Override
public void onItemClick(AdapterView<?> test, View v, int pos, long id) {
    String num = test.getItemAtPosition((int)id).toString();
    if (num.equalsIgnoreCase("11")) {
        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
        builder.setCancelable(true);
        LayoutInflater inflater = getLayoutInflater();
        View view = inflater.inflate(R.layout.eleven, null);
        builder.setView(view);
        builder.show();
    }
    else if (num.equalsIgnoreCase("12")) {
        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
        builder.setCancelable(true);
        LayoutInflater inflater = getLayoutInflater();
        View view = inflater.inflate(R.layout.twelve, null);
        builder.setView(view);
        builder.show();
    }