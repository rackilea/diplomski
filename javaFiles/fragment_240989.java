public void rollover() throws RolloverFailure {

    // when rollover is called the elapsed period's file has
    // been already closed. This is a working assumption of this method.

    String elapsedPeriodsFileName = timeBasedFileNamingAndTriggeringPolicy.getElapsedPeriodsFileName();

    String elapsedPeriodStem = FileFilterUtil.afterLastSlash(elapsedPeriodsFileName);

    if (compressionMode == CompressionMode.NONE) {
        if (getParentsRawFileProperty() != null) {
            renameUtil.rename(getParentsRawFileProperty(), elapsedPeriodsFileName);
        } // else { nothing to do if CompressionMode == NONE and parentsRawFileProperty == null }
    } else {
        if (getParentsRawFileProperty() == null) {
            compressionFuture = compressor.asyncCompress(elapsedPeriodsFileName, elapsedPeriodsFileName, elapsedPeriodStem);
        } else {
            compressionFuture = renameRawAndAsyncCompress(elapsedPeriodsFileName, elapsedPeriodStem);
        }
    }

    if (archiveRemover != null) {
        Date now = new Date(timeBasedFileNamingAndTriggeringPolicy.getCurrentTime());
        this.cleanUpFuture = archiveRemover.cleanAsynchronously(now);
    }
}

Future<?> renameRawAndAsyncCompress(String nameOfCompressedFile, String innerEntryName) throws RolloverFailure {
    String parentsRawFile = getParentsRawFileProperty();
    String tmpTarget = nameOfCompressedFile + System.nanoTime() + ".tmp";
    renameUtil.rename(parentsRawFile, tmpTarget);
    return compressor.asyncCompress(tmpTarget, nameOfCompressedFile, innerEntryName);
}