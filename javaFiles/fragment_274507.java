collectorConfiguration = Optional.ofNullable(recapPlacement.getPnetCode())
            .flatMap(pnetCode -> collectorConfigurations.stream()
                    .filter(c -> pnetCode.equals(c.getPnetCode()))
                    .filter(Objects::nonNull)
                    .findFirst())
            .orElse(unknownExternalCollector);