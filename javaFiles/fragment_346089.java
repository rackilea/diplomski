public  static boolean recursion(int y) {
    int positive = Math.abs(y);
    if(positive%10==1 || positive%10==2 || positive%10==3) {
        return true;
    } else if (positive == 0) {
        return false;
    }
    return recursion(positive / 10);
}