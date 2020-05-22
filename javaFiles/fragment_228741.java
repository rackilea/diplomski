public boolean hasFirst() {
   return types.parallelStream()
       .filter(it -> it.getTotalAmount() > 0)
       .map(TypeA::getFirst)
       .findFirst() // return Optional[Optional.empty]
       .flatMap(i -> i) // <---
       .isPresent(); // true
}