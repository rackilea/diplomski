String string = "any char with decimal value";       
int[]  a = new int[string.length()];

for(int x = 0; x < string.length() ; x++){
    a[x] = (int)string.charAt(x);
    System.out.println("value at " + x + " : " + string.charAt(x) + " in dec = " + a[x]);
}