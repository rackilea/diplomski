String secret = "hello world!"; // or anything else B)
StringBuilder sb = new StringBuilder();
for (char c : secret.toCharArray()) {
    // int casting wrap the char value 'c' to the corresponding ASCII code
    sb.append(String.format("%03d",(int)c));                        
}
System.out.println(sb); // -> 104101108108111032119111114108100033
// 'H' is 104, 'e' is 101, 'l' is 108, and so on..