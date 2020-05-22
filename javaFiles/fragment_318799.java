String [] encoded = {"(10)%(5)", "((20)%(2))%(5)", "((30)%(2))%(3+2)"};
    String decodeTerm = "([0-9+\\-*ABC\\[\\],]*)";
    String decodePattern = "\\(" + decodeTerm + "\\)%\\(" + decodeTerm + "\\)";
    for (String str : encoded) {
        while (true) {
            String replaced = str.replaceAll(decodePattern, "ABC[$1,$2]");
            if (replaced.equals(str)) {
                break;
            }
            str = replaced;
        }
        str = str.replaceAll("\\[", "(");
        str = str.replaceAll("\\]", ")");
        System.out.println(str);
    }