boolean isEmail(String check) {
    String[] emailDomains = {".com",".net",".org"};
    String[] emailProviders = {"gmail","yahoo","hotmail","aol","tds","comcast","charter","peoplepc"}; //add more if you want
    char[] check2 = check.toCharArray();
    for (int i = 0; i <= emailProviders.length; i++) {
        for (int x = 0; x <= emailDomains.length; x++) {
            if ((check.indexOf(emailDomains[x]).equals(check2.length)) && (check.indexOf(emailProviders[i]).equals(check2.length - emailDomains[x].toCharArray().length)) {
            return true;
            }
        }
    }
    return false;
}