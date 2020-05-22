List<VisitSummaryBySource> output =
        data.stream()
            .collect(groupingBy(VisitSummaryBySource::getSource,
                                reducing(VisitSummaryBySource::merge)))
            .values().stream()
            .map(Optional::get)
            .collect(toList());