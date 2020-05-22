class Data implements Comparable<Data> {

    float lati;
    float longi;
    Integer time;

    @Override
    public int compareTo(Data o) {
        // Integer already implements Comparable
        return time.compareTo(o.time);
    }

}