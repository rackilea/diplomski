String Fpath = data.getDataString();
String abspath = Fpath.substring(7);

File test = new File(abspath);
if(test.exists())
{
    //serialize it!
}