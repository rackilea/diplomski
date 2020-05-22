public static final String LESSER_STRING = "<(.[^>]*)(<)+";
    public static final String GREATER_STRING = ">[^<](.[^<]*)(>)+";
    public static final String ESCAPED_XML = "&lt;GetWhoISResponse xmlns=&quot;http://www.webservicex.net&quot;&gt;&lt;GetWhoISResult&gt;Whois Server Version 2.0 To single out one record, look it up with &quot;xxx&quot;, where xxx is one of the of the records displayed above. If the records are the same, look them up with &quot;=xxx&quot; to receive a full display for each record. &gt;&gt;&gt; Last update of whois database: Mon, 30 Dec 2013 08:20:00 UTC &lt;&lt;&lt; NOTICE: The expiration date displayed in this record is the date the registrar&apos;s sponsorship of the domain name registration in the registry is currently set to expire. This date does not necessarily reflect the expiration date of the domain name registrant&apos;s agreement with the sponsoring registrar.  Users may consult the sponsoring registrar&apos;s Whois database to view the registrar&apos;s reported date of expiration for this registration.&lt;/GetWhoISResult&gt;&lt;/GetWhoISResponse&gt;";
    private static Matcher matcher;
    private static Pattern pattern;
    private static String alter;
    private static StringBuffer str = new StringBuffer();
    private static StringBuffer jsonString = new StringBuffer();

    public static void main(String[] args) {
        String xml = StringEscapeUtils.unescapeXml(ESCAPED_XML);

        pattern = Pattern.compile(GREATER_STRING);
        matcher = pattern.matcher(xml);

        while (matcher.find()) {
            System.out.println(matcher.group(0));
            System.out.println(matcher.group(0).substring(1));

            // Find the first encountered greater than sing assuming greater
            // than and less than do not form a 'tag' pattern

            // Picks the first value after the 'last opened tag' including the
            // greater sign - take substring 1
            alter = ">" + matcher.group(0).substring(1).replaceAll(">", "&gt;");
            matcher.appendReplacement(str, alter);
        }

        matcher.appendTail(str);

        pattern = Pattern.compile(LESSER_STRING);
        matcher = pattern.matcher(str);

        while (matcher.find()) {
            System.out.println(matcher.group(0));
            System.out.println(matcher.group(0).substring(0,
                    matcher.group(0).length() - 1));

            // Find the encountered lesser than sign assuming greater
            // than and less than do not form a 'tag' pattern

            // Picks the content between the lesser tags and the last opened
            // tag; including the lesser sign of the tag
            // Reduce it by 1 to prevent the last tag getting replaced
            alter = matcher.group(0)
                    .substring(0, matcher.group(0).length() - 1);

            // Add the last tag as is without replacing
            alter = alter.replaceAll("<", "&lt;") + "<";
            matcher.appendReplacement(jsonString, alter);

        }

        matcher.appendTail(jsonString);

        System.out.println(jsonString);
    }