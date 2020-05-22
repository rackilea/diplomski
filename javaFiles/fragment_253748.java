int abvLen = abv.length();
int abvEndIndex = abvLen - 6;
if (abvEndIndex < 0) {
    log.error("ABV length less than 6", abv);
    abvEndIndex = 0;
}
String abvEnd = abv.substring(abvEndIndex, abvLen);