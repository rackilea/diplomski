List<String> list = Arrays.asList("1234","AAAA","aaaa","BBBB","bbbb");
Collator c = Collator.getInstance(Locale.ENGLISH);
c.setStrength(Collator.CANONICAL_DECOMPOSITION);

Collections.sort(list);
System.out.println("without collator: " + list);
Collections.sort(list, c);
System.out.println("with collator: " + list);