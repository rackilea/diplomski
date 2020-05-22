public void show_alert() {
    // TODO Auto-generated method stub

    final Dialog dia = new Dialog(this);
    dia.setContentView(R.layout.alert);
    dia.setTitle("Select File to import");
    dia.setCancelable(true);

    list_alert = (ListView) dia.findViewById(R.id.alert_list);
    list_alert.setAdapter(new ArrayAdapter<String>(getApplicationContext(),
            android.R.layout.simple_list_item_1,
            main_genral_class.file_list));
    list_alert.setOnItemClickListener(new OnItemClickListener() {
        public void onItemClick(AdapterView<?> arg0, View arg1, int pos,
                long arg3) {
            String fname = main_genral_class.file_list.get(pos);
            dia.dismiss();

        }
    });
    dia.show();
}