String s = args[0];
for(int i = 0; i < s.length(); i++) {
    char chr = s.charAt(i);
    if(chr != 'A' && chr != 'C' && chr != 'T' && chr != 'G') {
        System.out.println("invalid");
        return;
    }
}
System.out.println("valid");