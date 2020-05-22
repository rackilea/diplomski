String direction = "";
int lastIndex = move.length - 1;
switch(c[lastIndex]) {
    case 'L': direction = "West"; break;
    case 'U': direction = "North"; break;
    case 'D': direction = "South"; break;
    case 'R': direction = "East"; break;
    default: throw new IllegalArgumentException("Cannot accept movement " + c[lastIndex]);
}
System.out.println("Final Direction: " + direction);