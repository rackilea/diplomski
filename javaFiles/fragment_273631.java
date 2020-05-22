List<String> list1 = Arrays.asList(new String[] { "my", "sentence", "test", "for", "testing" });
List<String> list2 = Arrays.asList(new String[] { "my", "sentence", "test", "is", "this" });

Collections.sort(list1);
Collections.sort(list2);

Collection<String> tokensUnion2 = CollectionUtils.collate(list1, list2, false);