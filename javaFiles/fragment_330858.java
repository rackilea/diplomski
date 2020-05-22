public Iterator<Vehicles> vehicleIterator() {
   return new Iterator<Vehicles>() {
       Iterator<Car> it = this.cars.iterator();
       public boolean hasNext() { return it.hasNext(); }
       public Vehicles   next() { return it.next();    }
       public void     remove() {        it.remove();  }
   };
}