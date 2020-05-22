String resultString = subjectString.replaceAll(
    "(?x)<enclosure\\s+\n" +
    "length=\"\\d+\"\\s+\n" +
    "type=\"([^\"]+)\"\\s+\n" +
    "leadimage=\"([^\"]+)\"\\s+\n" +
    "caption=\"([^\"]+)\"\\s+\n" +
    "url=\"([^\"]+)\"\\s*\n" +
    "/>", "<enclosure>$1\r\n$2\r\n$3\r\n$4</enclosure>");