foo.stream()
   .filter(p -> p.someField == someValue)
   .findFirst().map(p -> {
       p.someField = anotherValue;
       someBoolean = true;
       return p;
   }).orElseGet(() -> {
       P p = new P();
       p.someField = evenAnotherValue;
       someBoolean = false;
       return p;
   });