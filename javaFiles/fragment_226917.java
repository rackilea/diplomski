private static String cleanTextContent(String text)
    {
        // strips off all non-ASCII characters
        text = text.replaceAll("[^\\x00-\\x7F]", "");

        // erases all the ASCII control characters
        text = text.replaceAll("[\\p{Cntrl}&&[^\r\n\t]]", "");

        // removes non-printable characters from Unicode
        text = text.replaceAll("\\p{C}", "");

        text = text.replaceAll("[^ -~]","");

        text = text.replaceAll("[^\\p{ASCII}]", "");

        text = text.replaceAll("\\\\x\\p{XDigit}{2}", "");

        text = text.replaceAll("\\n","");

        text = text.replaceAll("[^\\x20-\\x7e]", "");
        return text.trim();
    }