String regexString = Pattern.quote(pattern1) + "(.*?)" + "\\|\\|" + "(.*?)" + Pattern.quote(pattern2);
    Pattern pattern = Pattern.compile(regexString);
    Matcher matcher = pattern.matcher(msg);

    while (matcher.find()) {
        String replace = matcher.group(1); //Replacement string
        String action = matcher.group(2);  //Action String

        msg = msg.replaceFirst(regexString, replace);
    }

Log.e ("Display Message", msg);