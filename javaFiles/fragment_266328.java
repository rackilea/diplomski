public Comparable[] findCommonElements(Object[] collections) {
    //1.
    for each collection in collections
        Comparable[] compCollection = (Comparable[])collection
        sort(compCollection)
    end for
    //2.
    Comparable[] a1 = (Comparable[])collections[0]
    //assume MAX is a really high value like 10000
    //the best value for MAX would be the max length of the arrays in collections
    Comparable[] b = new Comparable[MAX]
    int bSize = 0
    //6.
    for i = 1 to collections.length - 1
        //5.
        Comparable[] a2 = (Comparable[])collections[i]
        //3.
        for each Comparable comp in a1
            int index = binarySearch(comp, a2)
            if index >= 0 then
                //4.
                add a2[index] into b
                bSize = bSize + 1
            end if
        end for
        //5.
        a1 = b
        b = new Comparable[MAX]
        bSize = 0
    end for
    return b
}