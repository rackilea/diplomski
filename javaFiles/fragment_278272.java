@Override
protected void onPostExecute(Void args) {
    // Locate spinner1 in activity_main.xml
    Spinner spinner1 = (Spinner) findViewById(R.id.spinner1);

    List<String> typesofjobsunique = new ArrayList<>(new LinkedHashSet<>(typesofjobs));
    spinner1.setAdapter(new ArrayAdapter<String>(MainActivity.this,
            android.R.layout.simple_spinner_dropdown_item, typesofjobsunique));

    // not sure if you want to keep original list
    Collections.sort(typesofjobs);