public enum Stuff { DEPARTMENT, OPERATOR, TERMINAL };
Stuff parent = ...;
Stuff child  = ...;

int selector = parent.ordinal() * Stuff.values().length + child.ordinal();
switch(selector)
{
    case 0 : // parent=DEPARTMENT child=DEPARTMENT
        ...
    case 1 : // parent=DEPARTMENT child=OPERATOR
        ...
        ...
    case 3 : // parent=OPERATOR child=DEPARTMENT
        ...
    case 8:  // parent=TERMINAL child=TERMINAL
        ...
}