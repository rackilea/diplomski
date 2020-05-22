CachedFunction<Integer, String> cachedFunction = new CachedFunction<>(
            id -> getTerminalName(id));

    final Map<String, List<TopTerminalsDTO>> final_map = list.stream()
            .filter(p -> p.getTerminal_id() != null)
            .collect(Collectors.groupingBy(
                    p -> cachedFunction.apply(p.getTerminal_id()),
                    terminalsCollector));