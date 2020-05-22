@Override
protected void onStart() {
    // TODO Auto-generated method stub
    super.onStart();
    List<Employee> contacts = db.getAllContacts();
    for (Employee cn : contacts) {
        String log = "Id: " + cn.get_id() + " ,Name: " + cn.get_name()
                + " ,Phone: " + cn.get_email();
        // Writing Contacts to log
        Log.d("Name: ", log);
    }
    ListView list = (ListView) findViewById(R.id.listView1);
    ContanctAdapter objAdapter = new ContanctAdapter(MainActivity.this,
                R.layout.alluser_row, contacts);
    list.setAdapter(objAdapter);
}