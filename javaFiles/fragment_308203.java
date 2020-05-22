public static void main(String[] args) {
        Instant now = Instant.now();
        Instant nxtWeek= now.plus(Duration.ofDays(7));

        Outer[] outers = {
                new Outer(new Inner("a"), null),
                new Outer(new Inner("b"), Date.from(now)),
                new Outer(new Inner("c"), Date.from(nxtWeek)),

                new Outer(new Inner("a"), Date.from(now)),
                new Outer(new Inner("b"), Date.from(nxtWeek)),
                new Outer(new Inner("c"), null),

        };

        Comparator<Outer> outerRanker = Comparator.comparing(Outer::getFinishDate, Comparator.nullsLast(Date::compareTo));

        Map<String, Outer> OutersById = Arrays.stream(outers)
                .collect(
                        Collectors.toMap(
                                outer -> outer.inner.id,
                                outer -> outer,
                                (a, b) -> outerRanker.compare(a,b) > 0 ? a : b
                                ));
        System.out.println("today: "+Date.from(now));
        OutersById.forEach((k,v)->System.out.println(k+", "+v));
    }