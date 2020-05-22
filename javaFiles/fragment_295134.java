Set<Type> types = EnumSet.noneOf(Type.class);
SortedSet<String> codes = new TreeSet<String>();
for(Toy toy: toys) {
   types.add(toy.getType());
   codes.add(toy.getCode());
}