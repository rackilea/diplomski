TerminalNameCache cache = new TerminalNameCache();

    final Map<String, List<TopTerminalsDTO>> final_map = list.stream()
            .filter(p -> p.getTerminal_id() != null)
            .collect(Collectors.groupingBy(
                    p -> cache.getTerminalName(p.getTerminal_id()),
                    terminalsCollector));