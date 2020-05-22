print(animal2, new CheckTrait() {
       @Override
     public boolean test(Animal s) {
           return s.canHop();
     }
});