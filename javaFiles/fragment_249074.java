DailyOCF mergeDailyOCF(DailyOCF dailyOCF1, DailyOCF dailyOCF2) {
    return new DailyOCF(dailyOCF1.planYearMonth, dailyOCF1.carSeries, dailyOCF1.weekNo,
            dailyOCF1.factoryCode, dailyOCF1.lineClass, dailyOCF1.day,
            mergeOCFInfo(dailyOCF1.ocfInfo, dailyOCF2.ocfInfo), Math.max(dailyOCF1.maxQty, dailyOCF2.maxQty),
            Integer.sum(dailyOCF1.actualQty, dailyOCF2.actualQty)); // assign 'actualQty = 1' as default
}

OCFIdentificationInfo mergeOCFInfo(OCFIdentificationInfo info1, OCFIdentificationInfo info2) {
    return info1;
    // implement custom logic if required
    // return new OCFIdentificationInfo(info1.frameSortCode, info1.ocfClassificationCode,
    // info1.locationIdentificationCode, info1.carGroup, info1.frameCode);
}