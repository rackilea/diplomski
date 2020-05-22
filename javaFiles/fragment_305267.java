listA.stream()
            .flatMap(a -> listB.stream().filter(b -> b.getId().equals(a.getId())).map(b -> {
                a.setRating(b.getRating());
                a.setStatus(b.getStatus());
                return a;
            }))
            .collect(Collectors.toList());