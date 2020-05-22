String s = "helloworld";    

// Encode:
String enc = "";
for (char c : s.toCharArray())
    enc += encoding.get(c);

System.out.println(enc);

// Decode:
String dec = "";
for (char c : enc.toCharArray())
    dec += decoding.get(c);

System.out.println(dec);