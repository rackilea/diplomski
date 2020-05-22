class Zoo {
 private Collection<Animal> animals;

 ...
 public void soundOff() {
  Iterator<Animal> i = animals.iterator();
  while( i.hasNext() )
   i.next().speak();
 }