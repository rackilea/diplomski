public enum Comparators {

     BY_NAME(F.CompareByName),
     BY_DATE(F.CompareByDate);

     private Comparator comparator;

     Comparators(final Comparator comparator) {
          this.comparator = comparator;
     }

     public Comparator getComparator() {
          return comparator;
     }

}


...

class F implements Parcelable {

    List<String> comparatorNames = new ArrayList<>();

    ....   ..

    writeToParcel() {

         //write list
    }


    readFromParcel() {

         //read list
    }

}