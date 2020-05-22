static final Comparator<Point> identityComparator = (p1, p2) -> 0;

Comparator<Point> normalComparator = (p1, p2)->p1.x.compareTo(p2.x);

(or Comparator<Point> normalComparator = Comparator.comparing(p -> p.x))

points.stream()
.sorted(sortThePoints ? normalComparator : identityComparator)
.forEach(System.out::println);