InputStream stream; 
char c; 
String s = ""; 
do {
   c = stream.read(); 
   if (c == '\n')
      break; 
   s += c + "";
} while (c != -1);