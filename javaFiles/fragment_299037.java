JavaRDD<String> rawInputRdd = sparkContext.textFile(dataFile);

Function2 removeHeader= new Function2<Integer, Iterator<String>, Iterator<String>>(){
    @Override
    public Iterator<String> call(Integer ind, Iterator<String> iterator) throws Exception {
        if(ind==0 && iterator.hasNext()){
            iterator.next();
            return iterator;
        }else
            return iterator;
    }
};
JavaRDD<String> inputRdd = rawInputRdd.mapPartitionsWithIndex(removeHeader, false);