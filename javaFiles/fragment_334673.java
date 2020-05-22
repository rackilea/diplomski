StringBuilder sb = new StringBuilder();// builder is empty now

// some logic
for (char ch = 'a'; ch <= 'z'; ch++) {
    // for this example we will just add all lower-case 
    // characters to builder
    sb.append(ch);
}
// after all characres are placed in builder 
// lets convert it to string
String alphabet = sb.toString();

// and see what we got
System.out.println(alphabet);