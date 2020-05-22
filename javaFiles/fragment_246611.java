final Employee e = Employee.setName(e, "Name"); // invalid, e is unkown

// ----------------

final Employee e;
e = Employee.setName(e, "Name"); // invalid, e may not be initialized

// ----------------

final Employee e;
e = Employee.setName("Name"); // valid

// ----------------

final Employee e = null;
e = Employee.setName(e, "Name"); // invalid. e was already initalized to null

// ----------------

final Employee e = Employee.setName("Name"); // valid
e = Employee.setName("Name2"); // invalid, final variable already initialized