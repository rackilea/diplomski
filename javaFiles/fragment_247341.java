public void removeFile(int index)
    {
        if(validIndex(index))
        {
            files.remove(index);
        }

    }




   public boolean validIndex(int index)
   {
       return (index >= 0 && index < files.size() - 1);
   }