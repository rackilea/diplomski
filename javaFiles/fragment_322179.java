String report = 
    (" map " + StringUtils.formatPercent(mapProgress(), 0)+
        " reduce " + 
        StringUtils.formatPercent(reduceProgress(), 0));
  if (!report.equals(lastReport)) {
    LOG.info(report);
    lastReport = report;
  }