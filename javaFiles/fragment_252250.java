List<Cell> cells = new ArrayList<Cell>();
for ( int i = 0; i < 50; i++ ){
    for ( int j = 0; j < 50; j++ ){
        Cell c = new Cell(i,j);
        cells.add(c);

    }
}
System.out.println(cells.size() + " cells generated");
System.out.println("Testing " + (cells.size()*cells.size()) + " number of Routes");
Set<Integer> set = new HashSet<Integer>();
int collisions = 0;
for ( int i = 0; i < cells.size(); i++ ){
    for ( int j = 0; j < cells.size(); j++ ){
        Route r = new Route(cells.get(i), cells.get(j));
        if ( set.contains(r.hashCode() ) ){
            collisions++;
        }
        set.add(r.hashCode());
    }
}
System.out.println(collisions);