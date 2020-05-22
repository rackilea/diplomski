while (iSet1.hasNext()) { // to iterate over the first set
    int i = iSet1.next();
    iSet2 = secondSet.iterator(); // <- re-initialize the iterator here
    while (iSet2.hasNext()) { // to iterate over the second set
        int j = iSet2.next();               
        System.out.printf("(%d,%d)",i,j);
    } // end of inner while
} // end of outer while