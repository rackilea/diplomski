@Override
public void onClick(View v) {
    // TODO Auto-generated method stub

    if(v==button)
    {
        savePreferences("storedName", editText.getText().toString());    
        Toast.makeText(getApplicationContext(), "Meldingtekst is aangepast.", Toast.LENGTH_LONG).show();
    }

    else if(v==button1)    
    {    
        savePreferences1("storedOnderwerp", editText1.getText().toString());    
        Toast.makeText(getApplicationContext(), "Meldingonderwerp is aangepast.", Toast.LENGTH_LONG).show();
    }
}