String termString = "([0-9+\\-*/()%]*)";
    String pattern = "ABC\\(" + termString + "\\," + termString + "\\)";
    String [] strings = {"ABC(10,5)", "ABC(ABC(20,2),5)", "ABC(ABC(30,2),3+2)"};
    for (String str : strings) {
        while (true) {
            String replaced = str.replaceAll(pattern, "($1)%($2)");
            if (replaced.equals(str)) {
                break;
            }
            str = replaced;
        }
        System.out.println(str);
    }