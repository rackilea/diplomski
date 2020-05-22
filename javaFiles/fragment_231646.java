class TupleComparator implements Comparator<Tuple2<Integer, Integer>>, Serializable {
@Override
public int compare(Tuple2<Integer, Integer> o1, Tuple2<Integer, Integer> o2) {
    if (o1._1() == o2._1())
        return o1._2() - o2._2();
    return o1._1() - o2._1();
  }
}