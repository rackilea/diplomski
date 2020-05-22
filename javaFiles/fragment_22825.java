public String getResult(String text) {

    Pattern pattern = Pattern.compile("(\\{.*)\\}");
    Matcher matcher = pattern.matcher(text);
    if (matcher.find()) {
        return matcher.group(1);
    } else {
        return null;
    }
}

public static void main(String args[]) {
    Mcve mcve = new Mcve();
    String text = "{HHH { AAAA } fS } SFS}";

    while ((text = mcve.getResult(text)) != null) {
        System.out.println(text);
    }
}