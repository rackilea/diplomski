Map<GroupByYearMonthStageDTO, DoubleSummaryStatistics> collect = list.stream()
            .collect(groupingBy(d -> new GroupByYearMonthStageDTO(d.getYear(), d.getMonth(), d.getStage()),
                            summarizingDouble(DealDTO::getAmount)));

collect.forEach(GroupByYearMonthStageDTO::setStatistics);
Set<GroupByYearMonthStageDTO> groupByYearMonthStageDTOS = collect.keySet();