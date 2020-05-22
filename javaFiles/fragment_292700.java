String[] mappedPatterns = mapping.value();
if (mappedPatterns.length > 0) {
for (String mappedPattern : mappedPatterns) {
    if (!hasTypeLevelMapping && !mappedPattern.startsWith("/")) {
        mappedPattern = "/" + mappedPattern;
    }