public final Method NOT_FOUND = null;
private Method findMethodInDelegateClassWithParameters (String _szMethodName)
{
    @SuppressWarnings("rawtypes")
    Class _cDelegateClass = m_oDelegate.getClass();

    //Get and sort array for binary search if not done, ensure methods are alphabetical before Java 7 
    if (_arrSortedMethods==null){
        _arrSortedMethods = _cDelegateClass.getMethods();   
        Arrays.sort(_arrSortedMethods, new Comparator<Method>() {
               public int compare(Method m1, Method m2) {
                   return m1.getName().compareTo(m2.getName());
               }
        });
    }

    return binarySearchForMethodNamed(_arrSortedMethods, _szMethodName);
}

public Method binarySearchForMethodNamed(Method[] _arrMethods, String _szMethodName) {
    int left = 0;
    int right = _arrMethods.length - 1;
    return binarySearchMethods(_arrMethods, _szMethodName, left, right);
    }

private Method binarySearchMethods(Method[] _arrMethods, String _szMethodName, int left, int right) {
    if (right < left) {
            return NOT_FOUND;
    }

    int mid = (left + right) >>> 1;
    String _szArrayMethodName = _arrMethods[mid].getName();
    if (_szMethodName.compareTo(_szArrayMethodName)>0) {
            return binarySearchMethods(_arrMethods, _szMethodName, mid + 1, right);
    } else if (_szMethodName.compareTo(_szArrayMethodName)<0) {
            return binarySearchMethods(_arrMethods, _szMethodName, left, mid - 1);
    } else {
            return _arrMethods[mid];
    }               
}