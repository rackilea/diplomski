public static void main(String[] args) {
        String content = "complex content number=\"456\" with many linebreaks\n" +
                "signal number=\"123\" test otherNumber=\"XX\" endsignal\n" +
                "more complex content";

        Matcher m = Pattern.compile("signal.*?endsignal").matcher(content);
        StringBuffer sb = new StringBuffer();
        while (m.find()) {
            String match = m.group(0); // the whole match... including start/end signal.
            match = Pattern.compile("(?<=number=\").*?(\")").matcher(match).replaceAll("XXX");

            m.appendReplacement(sb, match);
        }
        m.appendTail(sb);
        content = sb.toString();       

        System.out.println(content);
    }