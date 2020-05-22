for (Iterator<?> entryIter = syndFeed.getEntries().iterator(); entryIter.hasNext();) {
    SyndEntry syndEntry = (SyndEntry) entryIter.next();

    if (syndEntry.getContents() != null) {
        for (Iterator<?> it = syndEntry.getContents().iterator(); it.hasNext();) {
            SyndContent syndContent = it.next();

            if (syndContent != null) {
                String value = syndContent.getValue();
            }
        }
    }
}