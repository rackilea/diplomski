static VisitSummaryBySource merge(VisitSummaryBySource a,
                                  VisitSummaryBySource b) {
    assert a.getSource().equals(b.getSource());
    return new VisitSummaryBySource(a.getSource(), 
                                    a.getRecordCount() + b.getRecordCount(),
                                    a.getErrorCount() + b.getErrorCount());
}