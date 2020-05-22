Map<Date, Double> hoursMap = groupedByDate.entrySet()
        .stream()
        .collect(Collectors.toMap(Map.Entry::getKey, // for a key and not an entry
                e -> e.getValue().stream()
                        .mapToDouble(TimesheetContribution::getHours)
                        .sum()));