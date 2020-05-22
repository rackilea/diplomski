Map<String, Integer> map =
        list.stream()
            .collect(
                HashMap::new,
                (m, i) -> {
                    m.merge(i.name1, i.value1, Integer::sum);
                    m.merge(i.name2, i.value2, Integer::sum);
                },
                (m1, m2) -> m2.forEach((k, v) -> m1.merge(k, v, Integer::sum))
            );