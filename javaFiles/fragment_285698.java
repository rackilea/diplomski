LinkedList<List<Row>> all = new LinkedList<>(Arrays.asList(new ArrayList<>()));
readData
        .forEach(v -> {
            if (!all.getLast().isEmpty()) {
                // check if in 24h boundary
                LocalDateTime upperValue = all.getLast().get(0).getDate().plusHours(24);
                if (!upperValue.isAfter(v.getDate())) {
                    // create copy with row older earlier than 24h
                    LocalDateTime lowerValue = v.getDate().minusHours(24);
                    all.add(new ArrayList<>(all.getLast().stream()
                            .filter(r -> lowerValue.isBefore(r.getDate()))
                            .collect(Collectors.toList())));
                }
            }
            all.getLast().add(v);
        });