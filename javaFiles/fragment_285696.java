List<List<Row>> all = new ArrayList<>();
all.add(readData
        .map(Arrays::asList)
        .reduce(new ArrayList<>(), (a, v) -> {
            if (a.isEmpty()) {
                a.addAll(v);
            } else {
                LocalDateTime first = a.get(0).getDate().plusHours(24);
                if (first.isAfter(v.get(0).getDate())) {
                    a.addAll(v);
                } else {
                    all.add(a);

                    LocalDateTime last = v.get(0).getDate().minusHours(24);
                    a = new ArrayList<>(a.stream()
                            .filter(r -> last.isBefore(r.getDate()))
                            .collect(Collectors.toList()));
                    a.addAll(v);

                }
            }
            return a;
        }));