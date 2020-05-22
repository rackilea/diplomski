// Using varargs
field.equal(DSL.any(1, 2, 3));

// Using an actual array
Integer array = { 1, 2, 3 };
field.equal(DSL.any(array));