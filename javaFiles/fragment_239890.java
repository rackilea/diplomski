class Pair implements Comparable<Pair> {
    private String value;
    private long   weight;
    public Pair( String v, long w ){
        value = v;
        weight = w;
    }
    public void addWeight( long w ){
        weight += w;
    }
    public String getValue(){
        return value;
    }
    public long getWeight(){
        return weight;
    }
    public int compareTo(Pair other){
        return this.weight > other.weight ? -1 :
            this.weight == other.weight ? 0 : 1;
    }
}

public static List<String> merge( List<String>... lists ){
    Map<String,Long> v2w = new HashMap<>();
    // combine the lists, adding the weights according to list priorities.
    long w = 1 << lists.length - 1;
    for( List<String> list: lists ){
        for( String s: list ){
            Long weight = v2w.get(s);
            if( weight == null ){
                weight = w;
            } else {
                weight += w;
            }
            v2w.put( s, weight );
        }
        w = w >> 1;
    }
    // create the list of Pair values: String+weight
    List<Pair> pairs = new ArrayList<>();
    for( Map.Entry<String,Long> vw: v2w.entrySet() ){
        pairs.add( new Pair( vw.getKey(), vw.getValue() ) );
    }
    // sort
    Collections.sort( pairs );
    // extract result list
    List<String> res = new ArrayList<>();
    for( Pair pair: pairs ){
        res.add( pair.getValue() );
    }
    return res;
}