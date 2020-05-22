Set<Point> set = new HashSet<Point>();
Random position = new Random();
Point test;

do{
    test = new Point();
    test.x=position.nextInt(xx);
    test.y=position.nextInt(yy);   
    //xx and yy are the random number limits called from another part of the code
    set.add(test);     
}
while (set.size()<number);

List<Object> list = new ArrayList<Object>(set);
Object[] coord = list.toArray();