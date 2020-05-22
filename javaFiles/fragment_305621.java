ZonedDateTime start = ZonedDateTime.now();
ZonedDateTime end = ZonedDateTime.now().plusDays(5);
Predicate<ZonedDateTime> beforeEnd = date -> date.isBefore(end);
final long blockSize = 1;

List<DateBlock> blocks = new ArrayList<>();
Stream.iterate(start, d -> d.plus(blockSize, ChronoUnit.DAYS))
        .map(d -> d.plus(1, ChronoUnit.DAYS))
        .peek(i -> {
            if(beforeEnd.test(i))
                blocks.add(new DateBlock(i.minus(1, ChronoUnit.DAYS), i));
        })
        .allMatch(beforeEnd);