String text;
text="2:15";
if(text.contains(":")){
   text = text.replace(":",".");
}
Log.i("Tag",text);