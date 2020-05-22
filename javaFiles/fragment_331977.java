public static void main(String[] args) {
    Point a = new Point(0, 0);          // java.awt.Point
    Map<Point, Integer> map = new HashMap<Point, Integer>();
    map.put(a, 0);
    System.out.println(map.containsKey(new Point(0, 0)));    // true
    Integer value = map.remove(a);
    a.x = 1;
    map.put(a,value);
    System.out.println(map.containsKey(new Point(0, 0)));    // false
    System.out.println(map.containsKey(new Point(1, 0)));    // true
    System.out.println(map.containsKey(a));                  // true
}