Arrays.sort(datas, new Comparator<Integer[]>() {
         @Override
         public int compare(Integer[] entry1, Integer[] entry2) {
                if(entry1[0] == entry2[0]){
                       return entry2[1] - entry1[1];
                }
                return entry2[0] - entry1[0];
         }
});