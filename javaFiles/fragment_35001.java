// 1
switch (input) {
    case "A":
        return "1";
    case "B":
        return "2";
    default:
        return "0";
}

// 2
String varibleToReturn = null;
switch (input) {
    case "A":
        varibleToReturn = "1";
        break;
    case "B":
        varibleToReturn = "2";
        break;
    default:
        varibleToReturn = "0";
}
return varibleToReturn;

// 3
return switch(digitInDecimal) {
    case  0 -> '0';
    case  1 -> '1';
    case  2 -> '2';
    default -> '?';
}