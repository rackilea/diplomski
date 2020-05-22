List<Tuple> tuples = processes.stream()
        .flatMap(p0 -> processes.stream()
                .filter(p1 -> p0.getPid() != p1.getPid()
                           && p0.getProcessName().equals(p1.getProcessName()))
                .map(p1 -> new Tuple(p0, p1)))
        .collect(Collectors.toList());