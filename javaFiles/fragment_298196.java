public static boolean recursiveChecking(List<Integer> x,List<Integer> y) {
    if(x.size() == 0 || y.size() == 0){
        return false;
    } else if (x.get(0).equals(y.get(0))) {
        return true;
    } else {
        if (x.get(0) < y.get(0)) {
            return recursiveChecking(x.subList(1, x.size()-1), y);
        } else {
            return recursiveChecking(x, y.subList(1, y.size()-1));
        }
    }
}