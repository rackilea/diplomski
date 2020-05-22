TreeMap<Integer,Collection<Integer>> options = new TreeMap<Integer, Collection<Integer>>(); 
for(int i=0;i<17;++i) {
    for(int j=i+1;j<18;++j) {
        for(int k=j+1;k<19;++k) {
            for(int l=k+1;l<20;++l) {
                Integer timeTogether = time(i,j) + time(i,k) + time(i,l) + time(j,k) + time(j,l)+time(k,l);
                Collection<Integer> group = new HashSet<Integer>();
                group.add(i);
                group.add(j);
                group.add(k);
                group.add(l);
                options.put(timeTogether, group);
            }
        }
    }
}
Collection<Integer> golferLeft = new HashSet<Integer>(); // to quickly determine if we should consider a group.
for(int a=0; a < maxGolfers, a++) {
    golferLeft.add(a);
}

Collection<Collection<Integer>> finalPicks = new ArrayList<Collection<Integer>>();
do{
    Map.Entry<Integer, Collection<Integer>> least = options.pollFirstEntry();
    if (least != null && golferLeft.containsAll(least.getValue()) {
        finalPicks.add(least.getValue());
        golferLeft.removeAll(least.getValue());
    }
}while (golferLeft.size() > 0 && least != null);