public static int ans(List<Integer> abund, int total){
    for( int i = 0; i < abund.size(); ++i ){
        for( int j = i; j < abund.size(); ++j ){
            total -= abund.get(i) + abund.get(j);
        }
    }
    return total;
}

Set<Integer> abund=new HashSet<Integer>();  // List-ArrayList
fin = ans( new ArrayList( abund ), total );