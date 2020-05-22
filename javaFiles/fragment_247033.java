// TODO: For testing purposes, you'd want a Clock abstraction to be injected.
Date now = new Date();
DateFormat format = new SimpleDateFormat("MMM yyyy", Locale.ENGLISH);

// Each row...
for (...) {
    Date storedDate = format.parse(textFromDatabase);
    if (now.compareTo(storedDate) >= 0) {
        // It is now on or after the start of the given month
    }
}