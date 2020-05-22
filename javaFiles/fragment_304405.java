/**
 * This method will retrieve a string contained between string tags. You
 * specify what the starting and ending tags are within the startTag and
 * endTag parameters. It is you who determines what the start and end tags
 * are to be which can be any strings.<br><br>
 *
 * @param inputString (String) Any string to process.<br>
 *
 * @param startTag (String) The Start Tag String or String. Data content retrieved
 * will be directly after this tag.<br><br>
 *
 * The supplied Start Tag criteria can contain a single special wildcard tag
 * (~*~) providing you also place something like the closing chevron (>)
 * for an HTML tag after the wildcard tag, for example:<pre>
 *
 * If we have a string which looks like this:
 *      {@code
 *      "<p style=\"padding-left:40px;\">Hello</p>"
 *      }
 *      (Note: to pass double quote marks in a string they must be excaped)
 *
 * and we want to use this method to extract the word "Hello" from between the
 * two HTML tags then your Start Tag can be supplied as "&lt;p~*~&gt;" and of course
 * your End Tag can be "&lt;/p&gt;". The "&lt;p~*~&gt;" would be the same as supplying
 * "&lt;p style=\"padding-left:40px;\"&gt;". Anything between the characters &lt;p and
 * the supplied close chevron (&gt;) is taken into consideration. This allows for
 * contents extraction regardless of what HTML attributes are attached to the
 * tag. The use of a wildcard tag (~*~) is also allowed in a supplied End
 * Tag.</pre><br>
 *
 * The wildcard is used as a special tag so that strings that actually
 * contain asterisks (*) can be processed as regular asterisks.<br>
 *
 * @param endTag (String) The End Tag or String. Data content retrieval will
 * end just before this Tag is reached.<br>
 *
 * The supplied End Tag criteria can contain a single special wildcard tag
 * (~*~) providing you also place something like the closing chevron (&gt;)
 * for an HTML tag after the wildcard tag, for example:<pre>
 *
 * If we have a string which looks like this:
 *      {@code
 *      "<p style=\"padding-left:40px;\">Hello</p>"
 *      }
 *      (Note: to pass double quote marks in a string they must be excaped)
 *
 * and we want to use this method to extract the word "Hello" from between the
 * two HTML tags then your Start Tag can be supplied as "&lt;p style=\"padding-left:40px;\"&gt;"
 * and your End Tag can be "&lt;/~*~&gt;". The "&lt;/~*~&gt;" would be the same as supplying
 * "&lt;/p&gt;". Anything between the characters &lt;/ and the supplied close chevron (&gt;)
 * is taken into consideration. This allows for contents extraction regardless of what the
 * HTML tag might be. The use of a wildcard tag (~*~) is also allowed in a supplied Start Tag.</pre><br>
 *
 * The wildcard is used as a special tag so that strings that actually
 * contain asterisks (*) can be processed as regular asterisks.<br>
 *
 * @param trimFoundData (Optional - Boolean - Default is true) By default
 * all retrieved data is trimmed of leading and trailing white-spaces. If
 * you do not want this then supply false to this optional parameter.
 *
 * @return (1D String Array) If there is more than one pair of Start and End
 * Tags contained within the supplied input String then each set is placed
 * into the Array separately.<br>
 *
 * @throws IllegalArgumentException if any supplied method String argument
 * is Null ("").
 */
public static String[] getBetweenTags(String inputString, String startTag,
        String endTag, boolean... trimFoundData) {
    if (inputString == null || inputString.equals("") || startTag == null ||
            startTag.equals("") || endTag == null || endTag.equals("")) {
        throw new IllegalArgumentException("\ngetBetweenTags() Method Error! - "
                + "A supplied method argument contains Null (\"\")!\n"
                + "Supplied Method Arguments:\n"
                + "==========================\n"
                + "inputString = \"" + inputString + "\"\n"
                + "startTag = \"" + startTag + "\"\n"
                + "endTag = \"" + endTag + "\"\n");
    }

    List<String> list = new ArrayList<>();
    boolean trimFound = true;
    if (trimFoundData.length > 0) {
        trimFound = trimFoundData[0];
    }

    Matcher matcher;
    if (startTag.contains("~*~") || endTag.contains("~*~")) {
        startTag = startTag.replace("~*~", ".*?");
        endTag = endTag.replace("~*~", ".*?");
        Pattern pattern = Pattern.compile("(?iu)" + startTag + "(.*?)" + endTag);
        matcher = pattern.matcher(inputString);
    } else {
        String regexString = Pattern.quote(startTag) + "(?s)(.*?)" + Pattern.quote(endTag);
        Pattern pattern = Pattern.compile("(?iu)" + regexString);
        matcher = pattern.matcher(inputString);
    }

    while (matcher.find()) {
        String match = matcher.group(1);
        if (trimFound) {
            match = match.trim();
        }
        list.add(match);
    }
    return list.toArray(new String[list.size()]);
}