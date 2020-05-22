replaceAll("\\s*[\r\n]+\\s*", "%%"));
//or
replaceAll("[^\\S\r\n]*[\r\n]+[^\\S\r\n]*", "%%"));
//or
replaceAll("[\\p{Zs}\t]*[\r\n]+[\\p{Zs}\t]*", "%%"));
// or
replaceAll("[\\s&&[^\n\r]]*[\r\n]+[\\s&&[^\n\r]]*", "%%"));