String[] tests = {
        " ,achieve,achievement,achievable,,,",
        "agree,agreement,, ,agreeable,agreeably",
        ",apartment,,"
};
for (String line : tests){
    String[] elements = line.split(",", -1);
    StringJoiner sj = new StringJoiner(  "\", \"",  "\"",   "\""); 
                                       //delimiter, prefix, suffix
    for (String element : elements){
        sj.add(element);
    }
    System.out.println(sj);
}