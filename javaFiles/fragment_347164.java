final String[] strings = {"a", "B", "A", "á", "Á"};
final Collator collator = Collator.getInstance(Locale.FRANCE);
collator.setStrength(Collator.PRIMARY);

Collection<Set<String>> result = Arrays.stream(strings)
            .collect(Collectors.groupingBy(collator::getCollationKey, Collectors.toSet()))
            .values();
System.out.println(result); //[[a, A, á, Á], [B]]