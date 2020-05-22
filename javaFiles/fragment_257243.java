SomeClass someClass;
switch (type) {
  case FIRST:
    someClass = new SomeClass();
  break;
  case SECOND:
    OptionalLong optional = findSomeOptional();
    if(optional.isPresent()) {
      someClass = new SomeClass(optional.getAsLong());
    }
}