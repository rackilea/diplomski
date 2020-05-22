String resultString = subjectString.replaceAll(
    "(?x)(       # Match and capture in backreference number 1:\n" +
    " [^\\s:]+   #  one or more characters except spaces or colons\n" +
    ")           # End of capturing group 1\n" +
    ":           # Match a colon\n" +
    "(           # Match and capture in backreference number 2:\n" +
    " [^\\s:]+   #  one or more characters except spaces or colons\n" +
    ")           # End of capturing group 2", 
    "\"$1\" = '$2'");