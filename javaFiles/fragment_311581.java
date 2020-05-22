boolean hasValidFileSize(File file, double maxFileSize) {
    double bytes = file.length();
    double megabytes = (kilobytes / 1024) / 1024;

    if (megabytes > maxFileSize) {
        return false;
    }
    return true;
}