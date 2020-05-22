// This code...
float v = (Float)elem.get(names[i]);
arg.add(v);

// Will actually be equivalent to:
float v = (Float)elem.get(names[i]);
Float boxed = v;
arg.add(boxed);