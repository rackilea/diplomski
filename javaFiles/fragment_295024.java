Collections.sort(list, new Comparator<int[]>() {
    public int compare(int []a,int []b) {
        for(int i=0;i<6;i++)
            if(a[i]!=b[i]) return a[i]-b[i];
        return a[6] - b[6];
    }
});