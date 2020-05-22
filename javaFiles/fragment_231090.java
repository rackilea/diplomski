String result = Pattern.compile(myRegex)
        .matcher(myText)
        .results()
        .map(m -> m.group(1))
        .findFirst()
        .orElse(null);