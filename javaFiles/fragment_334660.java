int first= 0;
    int last= a.length - 1;
    while (first<= last) {
        int middle = first+ (last- first) / 2;
        if      (user.compareTo(list.get(middle)) < 0) last = middle - 1;
        else if (user.compareTo(list.get(middle)) > 0) first= middle + 1;
        else {
        found =1 ;
        break;
        }
    }