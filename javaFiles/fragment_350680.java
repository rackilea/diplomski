for(final String field : n.getFields()){
    // create a regex-matcher
    final Matcher matcher = pattern.matcher(field);

    // if field matches regex
    if(matcher.matches()){
        // get the last group -> the fieldName
        final String name = matcher.group(matcher.groupCount());
        System.out.println("FieldName: " + name);
    }
}