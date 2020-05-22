final Set<Car> second = newTreeSet( new Comparator<Car>(){
    public int compare( final Car o1, final Car o2 ){
        return o1.getColor().compare( o2.getColor() );  //return 0 when predicate return true
    }
} );
second.add( new Car(1, "green")  );