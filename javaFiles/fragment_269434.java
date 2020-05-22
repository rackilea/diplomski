String s="AABBBAAAABBAB";
int run=1;
// fetch first char
char temp=s.charAt(0);

// traverse char array
for (char ch : s.toCharArray()) {
    // assign value of new char to temp and increment run 
    // when value of char changes
    if (ch!=temp) {
        run++;
        temp=ch;
    }

}
System.out.println(run);