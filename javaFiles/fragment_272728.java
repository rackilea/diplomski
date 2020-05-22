@Override
    public void onItemClick(AdapterView<?> adapter, View arg1, int position, long arg3) {
        // TODO Auto-generated method stub
        String item = adapter.getItemAtPosition(position).toString();
        Toast.makeText(Test.this, "CLICK: " + item, Toast.LENGTH_SHORT).show();
    }