private static final Pattern REGEX_PATTERN = 
        Pattern.compile("(?<=\\[\\[test: )[^]]+");

public static void main(String[] args) {
    String input = "lopsakf pkpsdkf pskadp fkpsdkfp sdaf\noksflksflslkf sdlf kasldfk lasdkf lsadfk \nlopsakf pkpsdkf pskadp fkpsdkfp sdaf\noksflksflslkf sdlf kasldfk lasdkf lsadfk lopsakf pkpsdkf pskadp fkpsdkfp sdaf\noksflksflslkf sdlf kasldfk lasdkf lsadfk \n\n[[test: lls]]\n[[test: askd]]\n[[test: mmdm]]\n[[test: owow]]\n[[test: www]]\n[[test: wowow]]";

    Matcher matcher = REGEX_PATTERN.matcher(input);
    while (matcher.find()) {
        System.out.println(matcher.group());
    }
}