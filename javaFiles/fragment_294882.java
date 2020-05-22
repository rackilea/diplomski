boolean isFirst = true;
for (Map.Entry<String, List<String>> entry : warningMap.entrySet()) {
    List<String> warnings = entry.getValue();
    if (warnings != null) {
        for (String warning : warnings) {
            if (!isFirst) {
                warningMessages.append(NEW_LINE);
            }
            isFirst = false;
            warningMessages.append(warning);
        }
    }
}