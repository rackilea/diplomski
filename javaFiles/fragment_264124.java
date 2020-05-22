String regex = "(?<=^|[+/(*)-])(\\d+)(?=[+/(*)-]|$)";

// $1 references to the first captured group ---v
String result1 = "3*8+5/2-4".replaceAll(regex, "$1.0");
//     ^--- "3.0*8.0+5.0/2.0-4.0"

String result2 = "3.0*8+5/2-4.0".replaceAll(regex, "$1.0");
//     ^--- "3.0*8.0+5.0/2.0-4.0"

String result3 = "3.0*(8+5)/(2-4.0)".replaceAll(regex, "$1.0");
//     ^--- "3.0*(8.0+5.0)/(2.0-4.0)"