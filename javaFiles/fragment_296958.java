public final class Foo
{
    public static void main(final String... args)
        throws IOException
    {
        // What the JSON value must match exactly
        // Not anchored since it will be used with the (misnamed) .matches() method
        final Pattern pattern
            = Pattern.compile("\\\\/Date\\((\\d+)(-\\d+)?\\)\\\\/");

        final ObjectMapper mapper = new ObjectMapper();

        // Parse JSON...
        final JsonNode node = mapper.readTree(
            "{\"PostingDate\": \"\\/Date(1325134800000-0500)\\/\"}");

        if (!node.has("PostingDate")) {
            System.err.println("Bad JSON input!");
            System.exit(1);
        }

        // Get relevant field
        final String dateSpec = node.get("PostingDate").getTextValue();

        // Try and match the input.
        final Matcher matcher = pattern.matcher(dateSpec);

        if (!matcher.matches()) {
            System.err.println("Bad pattern!"); // Yuck
            System.exit(1);
        }

        // The first group capture the milliseconds, the second one the time zone

        final long millis = Long.parseLong(matcher.group(1));
        String tz = matcher.group(2);
        if (tz.isEmpty()) // It can happen, in which case the default is assumed to be...
            tz = "+0000";

        // Instantiate a date object...    
        final Date date = new Date(millis);

        // And print it using an appropriate date format
        System.out.printf("Date: %s %s\n",
            new SimpleDateFormat("yyyy/MM/dd HH:MM:ss").format(date), tz);
    }
}