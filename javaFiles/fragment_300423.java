line = buffered.readLine();
while (line != null) 
{
    if (val.equalsIgnoreCase(line)) 
    {
        Toast.makeText(this, "Working", Toast.LENGTH_LONG).show();
    }

    line = buffered.readLine();        
}