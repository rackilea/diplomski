public void OnClickListener(View v)
{
    final RadioButton manager = (RadioButton) findViewById(R.id.radioButton1);
    final RadioButton teamleader = (RadioButton) findViewById(R.id.radioButton2);

    Button proceed = (Button) findViewById(R.id.button1);
    proceed.setOnClickListener(new View.OnClickListener()
    {
        @Override
        public void onClick(View v) 
        {

        if(manager.isChecked()) {
            Intent managerIntent = new Intent(getApplicationContext(), ManagerQuestionnaire1.class); 
            startActivityForResult(managerIntent, 0);
        } else if (teamleader.isChecked()) {
              Intent teamleaderIntent = new Intent(getApplicationContext(),                 TeamleaderQuestionnaire1.class);
              startActivityForResult(teamleaderIntent, 0);
        }
    });
}