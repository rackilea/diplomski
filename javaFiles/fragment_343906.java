/**
 * This method will retrieve a string contained between String tags. You specify what the 
 * starting and ending tags are within the startString and endString parameters. It is you
 * who determines what the start and end strings are to be which can be any strings.<br><br>
 * 
 * @param filePath (String) The path and file name of the file you wish to process.<br><br>
 * 
 * @param startString (String) This method gathers data from between two specific strings.
 * This would be where the gathering would start from (after this string is detected) and
 * the gathering will end just before the supplied End String.<br><br>
 * 
 * @param endString (String) This method gathers data from between two specific strings.
 * This would be where the gathering would end at (before this string is detected) and
 * the gathering will start just after the supplied Start String.<br><br>
 * 
 * @param trimFoundData (Optional - Boolean - Default is true) By default all  data is 
 * trimmed of leading and trailing white-spaces before it is placed into the returned 
 * List object. If you do not want this then supply false to this optional parameter.<br><br>
 * 
 * @return (String List ArrayList) If there is more than one pair of Start Strings and 
 * End Strings within a file line then each set is placed into the List separately.<br>
 * 
 * @throws IllegalArgumentException if any supplied method String argument is a Null Sting
 * ("") or the supplied file is found not to exist.
 */
public static List<String> getBetween(final String filePath, final String startString, 
                                              final String endString, boolean... trimFoundData) {
    // Make sure all required parameters were supplied...
    if (filePath.equals("") || startString.equals("") || endString.equals("")) {
        throw new IllegalArgumentException("\nGetBetweenTags() Method Error! - "
                + "A supplied method argument contains Null (\"\")!\n"
                + "Supplied Method Arguments:\n"
                + "======================================\n"
                + "filePath = \"" + filePath + "\"\n"
                + "startTag = \"" + startString + "\"\n"
                + "endTag = \"" + endString + "\"\n");
    }   

    // See if the optional boolean trimFoundData argument was supplied.
    // This will trim the parsed strings found or tabs and whitespaces.
    boolean trimFound = true;
    if (trimFoundData.length > 0) { trimFound = trimFoundData[0]; }

    // The Java RegEx pattern to use so as to gather every 
    // encounter of text between the supplied Start String
    // and the supplied End String.
    String regexString = Pattern.quote(startString) + "(?s)(.*?)" + Pattern.quote(endString);
    Pattern pattern = Pattern.compile("(?iu)" + regexString);
    /* About the RegEx Expression:
          (?iu)         Sets the modes within the expression (enclosed in parenthases)
                        ?   Mode designation (non-greedy)
                        i   makes the regex case insensitive
                        u   turns on "ungreedy mode", which switches the syntax for 
                            greedy and lazy quantifiers.

          startString   Your supplied Start String. Text after this string is gathered 

          (?s)          Sets the mode again within the expression (enclosed in parenthases)
                        s   for "single line mode" makes the dot match all characters, 
                            including line breaks.

          (.*?)         Set up for a non-greedy group mode.
                        .   allow any character
                        *   allows haracter to occur zero or more times
                        ?   non-greedy.

          endString     Your supplied End String. Text before this string is gathered.
    */

    // Read in the supplied file for parsing.
    BufferedReader br = null;
    String inputString; // will hold each line of the file as it is read.
    // List to return holding the text parsed out of file lines.
    List<String> list = new ArrayList<>();
    try {
        //Make sure the supplied file actually exists...
        File file = new File(filePath);
        if (!file.exists()) {
            // Throw an exception if it doesn't...
            throw new IllegalArgumentException("\ngetBetween() Method Error!\n"
                    + "The file indicated below could not be found!\n"
                    + "(" + filePath + ")\n");
        }
        br = new BufferedReader(new FileReader(file));

        // Read in the file line by line...
        while ((inputString = br.readLine()) != null) {
            //If the line contains nothing then ignore it.
            if (inputString.equals("")) { continue; }
            // See if anything in the current line matches our RegEx pattern
            Matcher matcher = pattern.matcher(inputString);
            // If there is then add that text as an element in our List.
            while(matcher.find()){
                String match = matcher.group(1);
                // If rue was passed to the optional trimFoundData
                // parameter then trim the found text.
                if (trimFound) { match = match.trim(); }
                list.add(match);  // add the found text to the List.
            }   
        }    
    } 
    // Catch Exceptions (if any)... 
    catch (FileNotFoundException ex) { ex.printStackTrace(); }
    catch (IOException ex) { ex.printStackTrace(); }
    finally {
        try { 
            // Close the BufferedReader if open.
            if (br != null) { br.close(); } 
        } 
        catch (IOException ex) { ex.printStackTrace(); }
    }

    // Return the generated List.
    return list;
}