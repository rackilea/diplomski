public boolean removeAnObject(Element anObject)
  {
     String paramClass = anObject.getClassName();
     String currClass;

     for (int i = 0; i < currentSize; i++)
     {
        currClass = theList[i].getClassName();
        if (currClass.equals(paramClass))
        {
           if (theList[i].equals(anObject))
           {
              for (int j = i; j < currentSize-1; j++) {
                 theList[j] = theList[j+1];
              }
              currentSize--;
              return true;
           }
        }
     }

    // This object was not found in the set
     return false;
  }