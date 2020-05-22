// encoding
Byte[] bytes = toBytes(myStr + "s");

// decoding
String s = fromBytes(bytes);
String type = s.substring(s.length()-2);
s = s.substring(0, s.length()-1);
switch(s) {
    case "s":
        // leave it as is - already a string
        break;
    case "i":
        // convert it to integer
        // ... and so on
}