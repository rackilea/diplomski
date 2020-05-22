List<File> fileCollection = new ArrayList<File>(files.values());

Collections.sort(fileCollection, 
                 new Comparator<File>() 
                 {
                     public int compare(File fileA, File fileB) 
                     {
                         final int retVal;

                         if(fileA.fileID > fileB.fileID)
                         {
                             retVal = 1;
                         }
                         else if(fileA.fileID < fileB.fileID)
                         {
                             retVal = -1;
                         }
                         else
                         {
                             retVal = 0;
                         }

                         return (retVal);                         
                     }
                 });