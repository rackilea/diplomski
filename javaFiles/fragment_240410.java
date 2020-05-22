Pattern content = Pattern.compile("([\\w-]+)\\s*:\\s*([^;]+);");

    Matcher matcher = pattern.matcher(foo);
    while (matcher.find()) {
        // matcher.group(1); // This is the class name.
        // matcher.group(2); // This is the class contents.