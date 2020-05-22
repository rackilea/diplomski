Optional<RussianNestingDoll> thirdDoll = doll.getInnerDoll()
                 .flatMap(d -> d.getInnerDoll());

if (thirdDoll.isPresent()) {
  System.out.println(thirdDoll.get());
}
else {                 
  System.out.println("empty");
}