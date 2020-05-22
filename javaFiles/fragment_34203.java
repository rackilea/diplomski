Pattern regex = Pattern.compile(
    "\\b        # Start at word boundary\n" +
    "(?!temp_)  # Exclude words starting with temp_\n" +
    "[^,]+      # Match one or more characters except comma\n" +
    "(?=\\.)    # until the last available dot", 
    Pattern.COMMENTS);