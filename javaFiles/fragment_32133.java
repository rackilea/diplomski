class CustomBitSetComparator implements Comparator<BitSet>{
    int compare(BitSet a, BitSet b) {
        if(a == b){
            return 0;
        } else if(a == null) {
            return -1;
        } else if(b == null) {
            return 1;
        } else if(a.equals(b)) {
            return 0;
        } else if(a.length() > b.length()) {
            return 1;
        } else if(b.lenght() > a.length()) {
            return -1;
        } else {
            for(int i = 0; i < a.length(); i++) {
               if(a.get(i) != b.get(i)) {
                   if(a.get(i)) {
                      return 1;
                   } else {
                      return -1;
                   }
                }
             }
             return 0;
         }
    }
}