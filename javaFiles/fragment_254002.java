String hex = "F0BDC0";

// First convert the Hex-number into a binary number:
String bin = Integer.toString(Integer.parseInt(hex, 16), 2);

// Now create the complement (make 1's to 0's and vice versa)
String binCompl = bin.replace('0', 'X').replace('1', '0').replace('X', '1');

// Now parse it back to an integer, add 1 and make it negative:
int result = (Integer.parseInt(binCompl, 2) + 1) * -1;