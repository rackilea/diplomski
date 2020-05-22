int redMask   = 0b1111100000000000;
int greenMask = 0b0000011111100000;
int blueMask  = 0b0000000000011111;

String color = "0xFFE0";
int colorAsInteger = Integer.parseInt(color.substring(2,color.length()), 16); // convert the Hex value to int

int R = (colorAsInteger & redMask) >> 11; // keep only red bits
int G = (colorAsInteger & greenMask) >> 5; // keep only green bits
int B = colorAsInteger & blueMask; // keep only blue bits

System.out.println(R + " " + G + " " + B);