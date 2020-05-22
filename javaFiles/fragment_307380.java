public static String replace(String text , String bbcode , String imageLocation ){


        StringBuffer imageBuffer = new StringBuffer (""); 
        Pattern pattern = Pattern.compile(Pattern.quote(bbcode ));
        Matcher matcher = pattern.matcher(text);    
        StringBuilder builder = new StringBuilder();
        int i = 0;
        while (matcher.find()) {
            //String orginal = replacements.get(matcher.group(1));
            imageBuffer.append("<img src=\"" + imageLocation + "\" />");
            String replacement = imageBuffer.toString();
            builder.append(text.substring(i, matcher.start()));
            if (replacement == null) {
                builder.append(matcher.group(0));
            } else {
                builder.append(replacement);
            }
            i = matcher.end();
        }
        builder.append(text.substring(i, text.length()));
        return builder.toString();
    }