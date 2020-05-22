Map<MyKey, DailyOCF> finalResult = dailyOCFList.stream()
        .collect(Collectors.toMap(ocf -> new MyKey(ocf.planYearMonth, ocf.carSeries, ocf.weekNo, 
                        ocf.factoryCode, ocf.lineClass, ocf.ocfInfo.frameSortCode, 
                        ocf.ocfInfo.ocfClassificationCode, ocf.ocfInfo.locationIdentificationCode, 
                        ocf.ocfInfo.carGroup), Function.identity(), this::mergeDailyOCF));

List<DailyOCF> res = new ArrayList<>(finalResult.values());