PrintStream ps = new PrintStream(System.out);
ArrayList grammarRepo = new ArrayList();
String item, grammar;
String str = "( S ( NP-SBJ ( PRP I  )  )  ( INODE@S ( VP ( VBP have  )  ( NP ( DT a  )  ( INODE@NP ( NN savings  )  ( NN account  )  )  )  )  ( . . )  )  )";
// cleanup double spaces
while (str.contains("  ")){
    str = str.replaceAll("  ", " ");
}
// find no parenthesis zones!
Matcher m = Pattern.compile("\\([^\\(\\)]*\\)").matcher(str);

// loop until nothing left:
while (m.find()) {
    item = m.group();
    // make the grammar:
    grammar = item.substring(1, item.length()-1).trim().replaceFirst(" ", " -> ");

    if (!grammarRepo.contains(grammar)) {
        grammarRepo.add(grammar);
        ps.print(grammar + "\n");
    }

    str = str.replace(item, grammar.split(" -> ")[0]);
    m = Pattern.compile("\\([^\\(\\)]*\\)").matcher(str);
}