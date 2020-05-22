for (ReportItem ri : tcItems) {
    ReportItem matchingRI = findMatchingRI(ri);
    if (matchingRI != null) {
        // merge
    }
}

private ReportItem findMatchingRI(ReportItem ri) {
    for (ReportItem fcItem : fcItems) {
         if (fcItem.equals(ri)) 
             return fcItem;
    }
    return null;
}