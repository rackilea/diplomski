lparen(0), rparen(1), plus(2), minus(3), divide(4), times(5), mod(6), eos(7), pow(8), operand(9) ;


// Giving ^ (custom power) operator more precedence (14) than other (+,-,*,/,%) operators

/** in stack precedence **/
private static final int[] isp = {0, 19, 12, 12, 13, 13, 13, 0, 14};
/** incoming character precedence **/
private static final int[] icp = {20, 19, 12, 12, 13, 13, 13, 0, 14};
/** operators **/    
private static final char[] operators = {'(', ')', '+', '-', '/', '*', '%', ' ', '^'};
//                                        ^    ^ typo with '{' and '}'