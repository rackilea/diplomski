while (keys.hasNext())
{
    String keyValue = (String)keys.next();
    Toast.makeText(this, keyValue+":"+obj.getString(keyValue), Toast.LENGTH_LONG).show();
    resultaat.setText( resultaat.getText().toString()+ keyValue+":"+obj.getString(keyValue));
}