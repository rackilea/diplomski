public void list(File file) 
{
    if (file != null && file.isDirectory())
    {
       File[] children = file.listFiles();
       if (children != null)
       {
           for(int i = 0; i < children.length; i++)
           {
               if (children[i] != null)
               {
                   Log.d(TAG, children[i].getName());
               }
               list(children[i]);
           }
        }
    }
}