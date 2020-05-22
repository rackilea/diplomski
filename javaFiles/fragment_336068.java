final int lastPeriodPos = filePath.lastIndexOf(".");

if (lastPeriodPos >= 0) {
    filePathWithoutExt = filePath.substring(0, lastPeriodPos);
} else {
    filePathWithoutExt = filePath;