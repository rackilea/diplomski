String input = "A60B80A60";
List<WatchPeriod> result = new ArrayList<>();
Pattern.compile("(?=[AB])").splitAsStream(input)
    .map(WatchPeriod::forString)
    .forEachOrdered(wp -> result.add(result.isEmpty() ? wp : 
                          wp.after(result.get(result.size()-1))));
result.forEach(System.out::println);