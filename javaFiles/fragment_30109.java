Map<Boolean,Set<String>> periods = terminals
            .stream()
            .flatMap(terminal -> terminal.getApplicablePeriods().stream())
            .collect(Collectors.partitioningBy(TerminalPeriodApplicability::getIsRequired,
                                               Collectors.mapping(TerminalPeriodApplicability::name,
                                                                  Collectors.toSet()));