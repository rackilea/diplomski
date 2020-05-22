String inputString = "a = magic(3);\n" + 
        "%{\n" + 
        "sum(a)\n" + 
        "diag(a)\n" + 
        "sum(diag(a))\n" + 
        "%}\n" + 
        "sum(diag(fliplr(a)))";
System.out.println(inputString.replaceAll("(?s)%\\{.*?%\\}\n?", ""));