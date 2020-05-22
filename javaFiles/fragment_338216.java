for (int i = files.length-1; i >= 0; i--)
{
file = files[i];
Log.d("Count",file.getPath());
it.add (file.getPath());
}