String s1=" read the documentation for the methods of String"; //your string
char ch=s1.charAt(s1.indexOf('A'));  //first appearance of character A
int count = 0; 
for(int i=0;i<s1.length();i++) { 
    if(s1.charAt(i)=='A'){ //if character at index i equals to 'A'
        System.out.println("number of A:=="+ch);
        count++; //increment count
    }
}
System.out.println("Total count of A:=="+count);