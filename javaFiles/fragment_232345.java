String photoIdPatternAsString = "\\w+(?=\\/\\?)";

    Matcher postIdMatcher = Pattern.compile(photoIdPatternAsString).matcher(postUrl);

    if (postIdMatcher.find()) {
        postId = postIdMatcher.group(0);
    } else throw new IOException();