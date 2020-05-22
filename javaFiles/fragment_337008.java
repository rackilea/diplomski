// Consider a large initial size to even avoid reallocation, here I used 64 KB
StringBuilder sb = new StringBuilder(65536);

for (String[] classLines : writtenClasses)
    for (String lines : classLines)
        sb.append(lines).append('\n');

// Note: you might not even need to convert it to String, read reasoning below
String result = sb.toString();