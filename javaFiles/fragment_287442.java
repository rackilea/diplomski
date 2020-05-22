int getNumberOfPages(PageRanges pageRanges) {
    int pages = 0;
    int[][] ranges = pageRanges.getMembers();
    for (int i = 0; i < ranges.length; i++) {
        pages += 1;
        if (ranges[i].length == 2) {
            pages += ranges[i][1] - ranges[i][0];
        }
    }
    pages = Math.min(pages, totalPagesOfDocument);
    return pages;
}