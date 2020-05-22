ts.add("c");
//comparator will compare "c" and "c" (very silly but that's how is implemented)
//"c" will be the root of the tree
ts.add("e");
//comparator will compare "e" and "c"
//since "e" is lower than "c", "e" will be placed to the left of "c".
ts.add("b");
//comparator will compare "b" and "c"
//since "b" is greater than "c", "b" will be placed to the right of "c"
ts.add("a");
//comparator will compare "a" and "c"
//since "a" is greater than "c", "a" will be placed to the right of "c"
//but on its right is "b", so comparator will compare "a" and "b"
//since "a" is greater than "b", "a" will be placed to the right of "b"
ts.add("d");
//comparator will compare "d" and "c"
//since "d" is lower than "c", "d" will be placed to the left of "c"
//but on its left is "e", so comparator will compare "d" and "e"
//since "d" is greater than "e", "d" will be placed to the right of "e"
ts.add("g");
//comparator will compare "g" and "c"
//since "g" is lower than "c", "g" will be placed to the left of "c"
//but on its left is "e", so comparator will compare "g" and "e"
//since "g" is lower than "e", "g" will be placed to the left of "e"
ts.add("f");
//comparator will compare "f" and "c"
//since "f" is lower than "c", "f" will be placed to the left of "c"
//but on its left is "e", so comparator will compare "f" and "e"
//since "f" is lower than "e", "f" will be placed to the left of "e"
//but on its left is "g", so comparator will compare "f" and "g"
//since "f" is greater than "g", "f" will be placed to the right of "g"
//if the tree becomes unbalanced, TreeSet will be automatically balanced.