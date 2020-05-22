Path path =  ConstraintViolation.getPropertyPath();
// a path is an iterable of Path.Node objects
// the last node element in the path is the element that caused the violation
// You can get it's name via
Path.Node node = ...;
node.getName();