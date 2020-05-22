private static final Pattern numberpat = Pattern.compile("(?<=number=\")(.+?)(?=\")");
    private static final Pattern linepat = Pattern.compile("signal.*?endsignal");

    public static void main(String[] args) {
        String content = "complex content number=\"456\" with many linebreaks\n" +
                "signal number=\"123\" test otherNumber=\"A2\" endsignal\n" +
                "more complex content";

        Matcher m = linepat.matcher(content);
        StringBuffer sb = new StringBuffer();
        while (m.find()) {
            String match = m.group(0); // the whole match... including start/end signal.
            m.appendReplacement(sb, "");
            Matcher nmat = numberpat.matcher(match); // note the new regular expression with only one matching group
            while (nmat.find()) {
                nmat.appendReplacement(sb, nmat.group(0).replaceAll(".", "X"));
            }
            nmat.appendTail(sb);
        }
        m.appendTail(sb);
        content = sb.toString();       

        System.out.println(content);
    }