// var_l = var_l * a1[0]
var_l *= a1[0]; // a1 is a byte array of var2

// The low 16 bits of var_l are multipled by the low 8 bits of var_l (the parenthesis
// are not necessary in this case).
var_l = 0xFFFF & var_l * (0xFF & var_l);

// Self explanatory
if (var_l < 100L) {
 var_l = 2728L;
}