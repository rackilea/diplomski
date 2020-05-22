class IndexedArrayComparator implements Comparator<Integer>{

    MyEntry[] array;

    public IndexedArrayComparator(MyEntry[] entries){
        this.array=entries;
    }

    public Integer[] createIndexes(){
        Integer[] index = new Integer[array.length];
        for(int i =0;i<index.length;i++){
            index[i]=i;
        }
        return index;
    }

    public int compare(Integer i0, Integer i1) {
        double rfirst = array[i0].rank;
        double rsecond = array[i1].rank;

        double dfirst = array[i0].dist;
        double dsecond = array[i1].dist;

        if (rsecond != rfirst) {
            return rsecond > rfirst?-1:1;
        } 
        else if(dsecond!=dfirst){
            return dsecond > dfirst ?-1:1;
        }
        return 0; 
    }

}