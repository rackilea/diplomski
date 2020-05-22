Object[] ObjectList = AidStr.toArray();
  String[] StringArray = Arrays.copyOf(ObjectList,ObjectList.length,String[].class);

  /*One more method it is not working */
  String[] stringArr = AidStr.toArray(new String[AidStr.size()]);

  Spinner dropdown = (Spinner)findViewById(R.id.spinner_tag);
  dropdown.setOnItemSelectedListener(this);
  ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,    android.R.layout.simple_spinner_item, StringArray);
  adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
  dropdown.setAdapter(adapter);