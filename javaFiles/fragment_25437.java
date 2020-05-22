int maxSize = 20000;
int currentOffset = 0; // Increment by maxSize each iteration    
Iterable<List<?>> params = new ArrayList<>(StreamSupport
                            .stream(records.spliterator(), true)
                            .skip(currentOffset)
                            .limit(maxSize)
                            .map(r -> Arrays.asList(
                                    r.get("name"),
                                    r.get("surname"),
                                    r.get("something"),
                            ))
                            .collect(Collectors.toList())