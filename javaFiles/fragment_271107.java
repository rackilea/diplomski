private Object[] theList;

@Override
public boolean add(Object toAdd) {
    for(int i=0; i < theList.length; i++) {
        if(theList[i] == null){                  
            theList[i] = toAdd;

            return true;
        }         
    }

    return false;
}