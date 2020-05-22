List<RowTest> sortedList = getAllRowsThatNeedToBeSorted();
        Comparator comparator = new OrderAMTComparator();
        Collections.sort(sortedList, comparator);





    public class OrderAMTComparator implements Comparator<RowTest> {

        @Override
        public int compare(RowTest o1, RowTest o2) {
//Here you can use If condition to check which checkbox is selected and sort the list 
//repace getOrderAMT with other fields.

            BigDecimal compareRes = o1.getOrderAMT().getBigdecimalValue().subtract(o2.getOrderAMT().getBigdecimalValue());

//You can just return compareRes.compareTo(new BigDecimal(0))
//But Here I want to show that you can check any condition and return -1,1,0 as your
//requirement      

            if (compareRes.compareTo(new BigDecimal(0)) == -1) {
                return -1;
            } else if (compareRes.compareTo(new BigDecimal(0)) == 1) {
                return 1;
            } else if (compareRes.compareTo(new BigDecimal(0)) == 0 ) {
                return 0;
            }
            return compareRes.intValue();
        }
    }