private String Decode(String raw) {
    final Pattern UNICODE_CHARACTER_PATTERN = Pattern.compile("\\\\u([0-9A-Fa-f]{2,4})");

    StringBuilder sb = new StringBuilder(raw.length() / 7);

    Matcher matcher = UNICODE_CHARACTER_PATTERN.matcher(raw);

    while (raw.length() != 0) {
        if (raw.charAt(0) == '\\') {
            matcher = UNICODE_CHARACTER_PATTERN.matcher(raw);
            String hexCode = "";
            char[] decodedChars = null;
            boolean find = false;
            if (matcher.find()) {
                find = true;
                hexCode = matcher.group(1);
                decodedChars = Character.toChars(Integer.valueOf(hexCode, 16));
                sb.append(decodedChars);
            }
            if(find)
                raw = raw.substring(matcher.group(0).length());
            else {
                if(raw.length() > 2) {
                    char c = (raw.charAt(1));
                    raw = raw.substring(2);
                    switch(c) {
                        case 'n':
                            sb.append("\n");
                            break;
                        case 't':
                            sb.append("\t");
                            break;
                        case 'b':
                            sb.append("\b");
                            break;
                        case 'r':
                            sb.append("\r");
                            break;
                        case 'f':
                            sb.append("\f");
                            break;
                        case '\'':
                            sb.append("\\");
                            break;
                        case '\"':
                            sb.append("\"");
                            break;
                        default:
                            sb.append("\\"+c);
                            break;
                    }
                }else {
                    raw = raw.substring(1);
                    sb.append("\\");
                }
            }
        } else {
            sb.append(raw.charAt(0));
            raw = raw.substring(1);
        }
    }       

    return sb.toString();
}