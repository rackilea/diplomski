interface RepoA {
  List paginate(int count, int offset, SortCriteria sortCriteria);
}

interface RepoB {
 List paginate(int count, int offset, SortCriteria sortCriteria);
}

class RepoAB {
  private RepoA repoA;
  private repoB repoB;


  List paginate (int count, int offset, SortCriteria sortCriteria) {
     int aOffset = count == 0 ? 0 : calcAOffset(offset, sortCriteria);
     int bOffset = count == 0 ? 0 : offset - aOffset;
     return mergeSort(
             repoA.paginate(count, aOffset),
             repoB.paginate(count, bOffset),
             SortCriteria sortCriteria,
             50
           )
  }

  List mergeSort(List aList, List bList, SortCriteria sortCriteia, int stopAt) {
    ...
  }

  int calcAOffset (int offset, SortCriteria sortCriteria) {
    // This implementation can be very heavy, it will count all the records that
    // that appeared in the previous pages. 
    // You can evade this computation by knowing the offset using the last record 
    // in the previous page.
    return paginate(offset, 0, sortCriteria).filter(x => x instanceOf A).length
  }
}