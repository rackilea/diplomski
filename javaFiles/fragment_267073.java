return reports.stream()
        .collect(Collectors.toMap(report -> report.getOldId(),
                        report -> {
                    // batch processing for eServiceReportsMapByBatchFile
                            return eServiceReportsMapByBatchFile;
                }));