public static String searchFormail(String searchWord) {

    searchWord = searchWord.replaceAll("\\s+","");

    Pattern pattern = Pattern
            .compile("([_A-Za-z0-9-]+)(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9-]+)*(\\.[A-Za-z]{2,})");
    Pattern pattern2 = Pattern.compile("([\\w\\-]([\\.\\w])+[\\w]+)(\\(at\\))(([\\w\\-]+\\.)+[A-Za-z]{2,4})");

    Matcher matchs = pattern.matcher(searchWord);
    Matcher matchs2 = pattern2.matcher(searchWord);

    if(matchs.find()){
        return searchWord.substring(matchs.start(), matchs.end());
    }
    else if(matchs2.find()){
        return matchs2.replaceFirst("$1@$4");
    }

    return null;
}