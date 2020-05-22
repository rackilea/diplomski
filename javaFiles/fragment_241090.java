String text;
text= "2:15";
if(text.contains(":"))
{
    replace(":","."); // Will not cause anything as String is immutable. 
}
Log.i("Tag",text);