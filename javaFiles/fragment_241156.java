class Data implements Comparable<Data>{
    String url;
    double distance;

    @Override
    public int compareTo(Data other){
        // compareTo should return < 0 if this is supposed to be
        // less than other, > 0 if this is supposed to be greater than 
        // other and 0 if they are supposed to be equal
        int result = this.distance <= other.distance ? -1 : 1;
        return result;
    }
}