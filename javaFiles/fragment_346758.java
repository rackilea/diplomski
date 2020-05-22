JavaPairRDD<Integer,Integer[]> idWithIndexes = r1.join(r2).map(new Function<Tuple2<Integer,Tuple2<String[],String[]>>,Tuple2<Integer,Integer[]>>(){
    @Override
    public Tuple2<Integer, Integer[]> call(Tuple2<Integer, Tuple2<String[], String[]>> t) throws Exception {
        int id = t._1;
        String[] s1 = t._2._1;
        String[] s2 = t._2._2;
        int length = Math.min(s1.length, s2.length);

        List<Integer> index = new ArrayList<Integer>();
        for (int i = 0; i < length; i++) {
            if (!s1[i].equals(s2[i])) {
                index.add(i);
            }
        }

        return new Tuple2<Integer,Integer[]>(id, index.toArray(new Integer[0]));
    }   
});