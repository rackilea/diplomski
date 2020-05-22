public class ProgramThatDisplaysItself {

public static void main(String[] args) {
char space = (char)32;
char quote = (char)34;
String emptyStr = new String();
String spaceStr = String.valueOf(space);
String sixSpaces =
  emptyStr.concat(spaceStr).concat(spaceStr).concat(spaceStr)
          .concat(spaceStr).concat(spaceStr).concat(spaceStr);

String linesOfCode[] = {
  "package programthatdisplaysitself;",
  "",
  "public class ProgramThatDisplaysItself {",
  "",
  "  public static void main(String[] args) {",
  "    char space = (char)32;",
  "    char quote = (char)34;",
  "    String emptyStr = new String();",
  "    String spaceStr = String.valueOf(space);",
  "    String sixSpaces = ",
  "      emptyStr.concat(spaceStr).concat(spaceStr).concat(spaceStr)",
  "              .concat(spaceStr).concat(spaceStr).concat(spaceStr);",
  "",
  "    String linesOfCode[] = {",
  // Note: here's where the String array itself is skipped
  "    };",
  "",
  "    for ( int i = 0; i < 14; i++ ) {",
  "      System.out.println( linesOfCode[i] );",
  "    } // end for i",
  "",
  "    for ( int j = 0; j < linesOfCode.length; j++ ) {",
  "      System.out.println( sixSpaces + quote + linesOfCode[j] + quote + ',' );",
  "    } // end for j",
  "",
  "    for ( int k = 14; k < linesOfCode.length; k++ ) {",
  "      System.out.println( linesOfCode[k] );",
  "    } // end for k",
  "",
  "  } // end main()",
  "",
  "} // end class ProgramThatDisplaysItself",
}; // end linesOfCode[]
//display the lines until the String array elements
for ( int i = 0; i < 14; i++ ) {
  System.out.println( linesOfCode[i] );
} // end for i

//display the String array elements
for ( int j = 0; j < linesOfCode.length; j++ ) {
  System.out.println( sixSpaces + quote + linesOfCode[j] + quote + ',' );
} // end for j

//display the lines after the String array elements
for ( int k = 14; k < linesOfCode.length; k++ ) {
  System.out.println( linesOfCode[k] );
} // end for k

} // end main()

} // end class ProgramThatDisplaysItself