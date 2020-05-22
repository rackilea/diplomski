Tree tree = new Pine()

tree instanceof Pine; // true
tree instanceof Oak; // false
tree instanceof Tree; // true
tree instanceof Object; // true

Object something = new Oak();

something instanceof Pine; // false
something instanceof Oak; // true
something instanceof Tree; // true
something instanceof Object; // true