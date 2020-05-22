public static void arrayCopy (Object arr1 ,int pos1,Object arr2,int pos2,int limit){ 
    if ( (arr1 instanceof int[]) && (arr2 instanceof int[]) ) {
        int[] iArr1 = (int[]) arr1;
        int[] iArr2 = (int[]) arr2;
        ...
    }
    else if ( arr1 instanceof long[]) && (arr2 instanceof long[]) ) {
        long[] iArr1 = (long[]) arr1;
        long[] iArr2 = (long[]) arr2;
        ...
    }
    // ... etc.