private static void isIdentifier(String s) {
    boolean identifier = true;
    for (int i = 0; i < reserved_Keywords.length; i++) {
        if (s.equals(reserved_Keywords[i])) {
            identifier = false;
            break;
        }
    }

    if(identifier){
        System.out.print(s + "\t");
        System.out.println("Is Identifier");
    }
}