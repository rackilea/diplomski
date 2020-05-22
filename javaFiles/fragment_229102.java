EditText edd = findViewById(R.id.editTextData);
    Spinner spp = findViewById(R.id.spinnerCategory);

    String text1 = edd.getText().toString();
    String text2 = spp.getSelectedItem().toString();

    String filename = text2 + ".dat";

    try {
        File fa = new File(getFilesDir(),filename); //getting the filename path
        FileWriter fw = new FileWriter(fa,true);
        fw.write(text1 + "\n");
        fw.close();
        Toast.makeText(getBaseContext(), "Information Saved", Toast.LENGTH_SHORT).show();
    } catch (Exception e)
    {
        Toast.makeText(getBaseContext(), e.getMessage(), Toast.LENGTH_SHORT).show();
    } //End try catch statement