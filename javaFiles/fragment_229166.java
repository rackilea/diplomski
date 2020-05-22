class DummyComparator implements Serializable, Comparator<Tuple2<Integer, String> >{
            @Override
            public int compare(Tuple2<Integer, String> o1, Tuple2<Integer, String> o2) {
                return Integer.compare(o1._1(), o2._1());
            }
        }