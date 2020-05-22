int x = 0; //x is 0 by default
int y = 0; //y is 0 by default

try { 
    x = Integer.parseInt(a); //x will remain 0 in case of exception  
}
catch (NumberFormatException e) {
    e.printStackTrace();
}

try {  
    y = Integer.parseInt(b); //y will remain 0 in case of exception  
}
catch(NumberFormatException e) {
      e.printStackTrace();
}

return x + y; //return the sum