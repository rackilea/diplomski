private static final int INSIDE_QT = 1;
private static final int OUTSIDE_QT = 0;

public String[] parseLine(char delimiter, char quote, char quoteEscape, char charToEscapeQuoteEscaping, String logLine) {
           char[] line = logLine.toCharArray();
    List<String> strList = new ArrayList<>();
    int state = OUTSIDE_QT;
    char lastChar = '\0';
    StringBuffer currentToken = new StringBuffer();
    for (int i = 0; i < line.length; i++) {
        if (state == OUTSIDE_QT) {
            if (line[i] == delimiter) {
                strList.add(currentToken.toString());
                currentToken.setLength(0);
            } else if (line[i] == quote) {
                if (lastChar == quoteEscape) {
                    currentToken.deleteCharAt(currentToken.length() - 1);
                    currentToken.append(line[i]);
                } else {
                    if (removeQuotes == false) {
                        currentToken.append(line[i]);
                    }
                    state = INSIDE_QT;
                }
            } else if (line[i] == quoteEscape) {
                if (lastChar == charToEscapeQuoteEscaping) {
                    currentToken.deleteCharAt(currentToken.length() - 1);
                    currentToken.append(line[i]);
                    continue;
                } else {
                    currentToken.append(line[i]);
                }
            } else {
                currentToken.append(line[i]);
            }
        } else if (state == INSIDE_QT) {
            if (line[i] == quote) {
                if (lastChar != quoteEscape) {
                    if (removeQuotes == false) {
                        currentToken.append(line[i]);
                    }
                    if (currentToken.length() == 0) {
                        currentToken.append('\0');
                    }
                    state = OUTSIDE_QT;
                } else {
                    currentToken.append(line[i]);
                }
            } else if (line[i] == quoteEscape) {
                if (lastChar == charToEscapeQuoteEscaping) {
                    currentToken.deleteCharAt(currentToken.length() - 1);
                    currentToken.append(line[i]);
                    continue;
                } else {
                    currentToken.append(line[i]);
                }
            } else {
                currentToken.append(line[i]);
            }
        }
        lastChar = line[i];
    }
    if (lastChar == delimiter) {
        strList.add("");
    }
    if (currentToken.length() > 0) {
        strList.add(currentToken.toString());
    }
    return strList.toArray(new String[strList.size()]);
}