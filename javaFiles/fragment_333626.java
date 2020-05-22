JavaRDD<Tuple2<Integer, String>> artistByID0 = rawArtistData
                .flatMap(new FlatMapFunction<String, Tuple2<Integer, String>>() {
                    private static final long serialVersionUID = 1L;
                    @SuppressWarnings("unchecked")
                    public Iterable<Tuple2<Integer, String>> call(String s) {
                         String[] sarray = s.split("\t");
                         List<Tuple2<Integer, String>> returnList = new ArrayList<Tuple2<Integer, String>>();
                         if(sarray.length >= 2) 
                           returnList.add(new Tuple2<Integer, String> (Integer.parseInt(sarray[0]), sarray[1].trim()));
                         return returnList;
                        );
                    }
                });